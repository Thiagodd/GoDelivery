package com.thiagodd.godelivery.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CityNotFoundException extends EntityNotFoundException {

  @Serial
  private static final long serialVersionUID = -705641560019361323L;

  public CityNotFoundException(Long id) {
    super(String.format("Não foi possível encontrar cidade com o ID %d. Verifique se o ID fornecido está correto ou" +
        " entre em contato com o suporte para obter assistência.", id));
  }

  public CityNotFoundException(String message) {
    super(message);
  }

}
