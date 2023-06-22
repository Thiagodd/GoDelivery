package com.thiagodd.godelivery.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CookeryNotFoundException extends EntityNotFoundException {

  @Serial
  private static final long serialVersionUID = 2682502456208031173L;


  public CookeryNotFoundException(Long id) {
    super(String.format("Não foi possível encontrar cozinha com o ID %d. Verifique se o ID fornecido está correto ou" +
        " entre em contato com o suporte para obter assistência.", id));
  }

  public CookeryNotFoundException(String message) {
    super(message);
  }
}
