package com.godelivery.godelivery.domain.service;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.PaymentMethods;
import com.godelivery.godelivery.domain.repository.PaymentMethodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RegisterPaymentMethodsService {

    @Autowired
    private PaymentMethodsRepository paymentMethodsRepository;

    public PaymentMethods save(PaymentMethods paymentMethods){
        return paymentMethodsRepository.save(paymentMethods);
    }

    public PaymentMethods update(PaymentMethods paymentMethods){
        return paymentMethodsRepository.save(paymentMethods);
    }

    public void deleteById(Long id){
        if (!paymentMethodsRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(">>No PaymentMethods record found with ID %d.", id));
        }

        try {
            paymentMethodsRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(">>PaymentMethods with ID %d cannot be deleted as it is currently in use.", id));
        }
    }

}

