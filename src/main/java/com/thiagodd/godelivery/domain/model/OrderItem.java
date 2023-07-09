package com.thiagodd.godelivery.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class OrderItem {

 @Id
 @EqualsAndHashCode.Include
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private Integer quantity;

 private BigDecimal UnitPrice;

 private BigDecimal TotalPrice;

 private String note;
//
//  @ManyToOne
//  private Product product;
}
