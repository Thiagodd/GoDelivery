package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.PaymentMethods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodsRepository {

    List<PaymentMethods> findAll();
    PaymentMethods findById(Long id);
    PaymentMethods insert(PaymentMethods paymentMethods);
    PaymentMethods update(PaymentMethods paymentMethods);
    void remove (PaymentMethods paymentMethods);

}
