package com.thiagodd.godelivery.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PaymentMethodNotFound extends EntityNotFoundException {

 @Serial
 private static final long serialVersionUID = -6098450958745080913L;

 public PaymentMethodNotFound(Long id) {
  super(String.format("Não foi possível encontrar método de pagamento com o ID %d. Verifique se o ID fornecido está" +
      " correto ou entre em contato com o suporte para obter assistência.", id));
 }

 public PaymentMethodNotFound(String message) {
  super(message);
 }
}
