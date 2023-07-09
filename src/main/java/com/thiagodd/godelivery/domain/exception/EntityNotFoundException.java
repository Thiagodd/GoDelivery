package com.thiagodd.godelivery.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;


@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

 @Serial
 private static final long serialVersionUID = -4900339080489007839L;

 private final String title = "Entidade não encontrada";

 public EntityNotFoundException(Long id, Object entity) {
  super(String.format("Não foi possível encontrar %s com o ID %d. Verifique se o ID fornecido está correto ou" +
      " entre em contato com o suporte para obter assistência.", entity.getClass().getName(), id));
 }

 public EntityNotFoundException(String message) {
  super(message);
 }
}
