package com.thiagodd.godelivery.api.exceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.thiagodd.godelivery.domain.exception.BusinessException;
import com.thiagodd.godelivery.domain.exception.EntityInUseException;
import com.thiagodd.godelivery.domain.exception.EntityNotFoundException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    public static final String MSG_ERROR_FINAL_USER
        = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se "
        + "o problema persistir, entre em contato com o administrador do sistema.";


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        BindingResult bindingResult = ex.getBindingResult();


        List<ResponseError.Field> responseErrorFields = bindingResult.getFieldErrors().stream()
            .map(fieldError -> ResponseError.Field.builder()
                .name(fieldError.getField())
                .userMessage(fieldError.getDefaultMessage())
                .build())
            .toList();


        ResponseError responseError = createResponseErroBuilder(HttpStatus.valueOf(statusCode.value()), ProblemType.INVALID_DATA, detail)
            .fields(responseErrorFields)
            .build();

        return handleExceptionInternal(ex, responseError, headers, statusCode, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ProblemType problemType = ProblemType.SYSTEM_ERROR;

        ex.printStackTrace();

        ResponseError responseError = createResponseErroBuilder(status, problemType, MSG_ERROR_FINAL_USER)
            .build();

        return handleExceptionInternal(ex, responseError, new HttpHeaders(), status, request);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest request) {
        ResponseError responseError = createResponseErroBuilder(HttpStatus.NOT_FOUND, ProblemType.ENTITY_NOT_FOUND, exception.getMessage()).build();
        return handleExceptionInternal(exception, responseError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException exception, WebRequest request) {
        ResponseError responseError = createResponseErroBuilder(HttpStatus.BAD_REQUEST, ProblemType.BUSINESS_ERROR, exception.getMessage()).build();
        return handleExceptionInternal(exception, responseError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EntityInUseException.class)
    public ResponseEntity<?> handleEntityInUseException(EntityInUseException exception, WebRequest request) {
        ResponseError responseError = createResponseErroBuilder(HttpStatus.CONFLICT, ProblemType.ENTITY_IN_USE, exception.getMessage()).build();
        return handleExceptionInternal(exception, responseError, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        if (body == null || body instanceof String) {
            body = ResponseError.builder()
                .status(statusCode.value())
                .detail(exception.getMessage())
                .build();

            createResponseErroBuilder(HttpStatus.valueOf(statusCode.value()), ProblemType.ENTITY_NOT_FOUND, exception.getMessage()).build();
        }
        return super.handleExceptionInternal(exception, body, headers, statusCode, request);
    }


    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        if (ex instanceof MethodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatch(
                (MethodArgumentTypeMismatchException) ex, headers, HttpStatus.valueOf(status.value()), request);
        }

        return super.handleTypeMismatch(ex, headers, status, request);
    }


    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(
        MethodArgumentTypeMismatchException ex, HttpHeaders headers,
        HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.INCOMPRESSIBLE_PARAMETER;

        String detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s', "
                + "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
            ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());

        ResponseError problem = createResponseErroBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

        Throwable rootCause = ExceptionUtils.getRootCause(ex);
        if (rootCause instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, statusCode, request);
        }
        if (rootCause instanceof PropertyBindingException) {
            return handleIgnoredPropertyException((PropertyBindingException) rootCause, headers, statusCode, request);
        }

        String detail = "O corpo da requisição está invalido. Verifique erro de sintaxe ou tipo dos atributos.";

        ResponseError responseError = createResponseErroBuilder(HttpStatus.valueOf(statusCode.value()), ProblemType.INCOMPRESSIBLE_BODY, detail).build();

        return handleExceptionInternal(ex, responseError, headers, statusCode, request);
    }

    private ResponseEntity<Object> handleIgnoredPropertyException(PropertyBindingException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        String path = ex.getPath().stream().map(JsonMappingException.Reference::getFieldName).collect(Collectors.joining("."));

        String detail = String.format("A propriedade '%s' é invalida ou desconhecida. Verifique a sintaxe e corrija.", path);

        ResponseError responseError = createResponseErroBuilder(HttpStatus.valueOf(statusCode.value()), ProblemType.INCOMPRESSIBLE_BODY, detail).build();

        return handleExceptionInternal(ex, responseError, headers, statusCode, request);

    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

        String path = ex.getPath().stream().map(JsonMappingException.Reference::getFieldName).collect(Collectors.joining("."));

        String detail = String.format("A propriedade '%s' recebeu o valor '%s', que é de um tipo inválido. Corrija e informe " + "um valor compatível com o tipo '%s'.", path, ex.getValue(), ex.getTargetType().getSimpleName());
        ResponseError responseError = createResponseErroBuilder(HttpStatus.valueOf(statusCode.value()), ProblemType.INCOMPRESSIBLE_BODY, detail).build();

        return handleExceptionInternal(ex, responseError, headers, statusCode, request);
    }


    private ResponseError.ResponseErrorBuilder createResponseErroBuilder(HttpStatus status, ProblemType problemType, String detail) {
        return ResponseError.builder().status(status.value()).type(problemType.getUri()).title(problemType.getTitle()).detail(detail);
    }
}
