package com.thiagodd.godelivery.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

  ENTITY_NOT_FOUND("entity-not-found", "Entidade não encontrada"),
  CITY_NOT_FOUND("city-not-found", "Cidade não encontrada"),
  COOKERY_NOT_FOUND("cookery-not-found", "Cozinha não encontrada"),
  PAYMENT_METHOD_NOT_FOUND("payment-method-not-found", "Método de pagamento não encontrado"),
  PERMISSION_NOT_FOUND("permission-not-found", "Permissão não encontrada"),
  RESTAURANT_NOT_FOUND("restaurant-not-found", "Restaurante não encontrado"),
  STATE_NOT_FOUND("state-not-found", "Estado não encontrado"),
  ENTITY_IN_USE("entity-in-found", "Entidade em uso"),
  BUSINESS_ERROR("business-error", "Violação da regra de negócio"),
  INCOMPRESSIBLE_BODY("incompressible-body","Corpo da requisição incompreensível"),
  INCOMPRESSIBLE_PARAMETER("incompressible-parameter","Parâmetro da requisição incompreensível");

  private final String uri;
  private final String title;

  ProblemType(String path, String title) {
    this.uri = "https://godelivery.com.br/" + path;
    this.title = title;
  }
}
