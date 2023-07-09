package com.thiagodd.godelivery.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityInUseException extends RuntimeException {

 @Serial
 private static final long serialVersionUID = -6610938185317576701L;

 public EntityInUseException(Long id, String entityName) {
  super(String.format("Não foi possível excluir %s com o ID %d. A cidade está em uso e não pode ser removido no " +
      "momento.", entityName, id));
 }

 public EntityInUseException(String message) {
  super(message);
 }
}
