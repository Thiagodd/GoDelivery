package com.thiagodd.godelivery.domain.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends EntityNotFoundException {

 @Serial
 private static final long serialVersionUID = 6189724303377152538L;

 public RestaurantNotFoundException(Long id) {
  super(String.format("Não foi possível encontrar restaurante com o ID %d. Verifique se o ID fornecido está correto" +
      " entre em contato com o suporte para obter assistência.", id));
 }

 public RestaurantNotFoundException(String message) {
  super(message);
 }
}
