package com.thiagodd.godelivery.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StateNotFoundException extends EntityNotFoundException {

  @Serial
  private static final long serialVersionUID = 3173591335249251346L;

  public StateNotFoundException(Long id) {
    super(String.format("Não foi possível encontrar estado com o ID %d. Verifique se o ID fornecido está correto ou" +
        " entre em contato com o suporte para obter assistência.", id));
  }

  public StateNotFoundException(String message) {
    super(message);
  }
}
