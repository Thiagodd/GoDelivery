package com.thiagodd.godelivery.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PermissionNotFoundException extends  EntityNotFoundException {

  @Serial
  private static final long serialVersionUID = -4706873714160146413L;

  public PermissionNotFoundException(Long id) {
    super(String.format("Não foi possível encontrar restaurante com o ID %d. Verifique se o ID fornecido está correto" +
        " entre em contato com o suporte para obter assistência.", id));
  }

  public PermissionNotFoundException(String message) {
    super(message);
  }
}
