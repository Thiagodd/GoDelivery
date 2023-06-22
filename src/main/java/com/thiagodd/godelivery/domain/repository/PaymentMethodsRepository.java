package com.thiagodd.godelivery.domain.repository;

import com.thiagodd.godelivery.domain.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethod, Long> {


}
