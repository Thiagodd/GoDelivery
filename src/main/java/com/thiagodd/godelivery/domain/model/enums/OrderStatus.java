package com.thiagodd.godelivery.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
 CRIADO("Criado"),
 CONFIRMADO("Confirmado"),
 ENTREGUE("Entregue"),
 CANCELADO("Cancelado");

 private final String displayName;
}
