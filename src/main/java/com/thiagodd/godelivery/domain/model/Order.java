package com.thiagodd.godelivery.domain.model;

import com.thiagodd.godelivery.domain.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Order {

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal subTotal;

  private BigDecimal deliveryFee;

  @CreationTimestamp
  @Column(nullable = false, columnDefinition = "datetime")
  private LocalDateTime creationDate;

  @UpdateTimestamp()
  @Column(nullable = false, columnDefinition = "datetime")
  private LocalDateTime updateDate;

  @Column(columnDefinition = "datetime")
  private LocalDateTime confirmationDate;

  @Column(columnDefinition = "datetime")
  private LocalDateTime CanceledDate;

  @Column(columnDefinition = "datetime")
  private LocalDateTime deliveredDate;

  private OrderStatus status;

  @Embedded
  private Address address;

  @ManyToOne
  private User user;

  @ManyToOne
  private Restaurant restaurant;

  @ManyToOne
  private PaymentMethod paymentMethod;

  @OneToMany
  private List<OrderItem> orderItems = new ArrayList<>();
}
