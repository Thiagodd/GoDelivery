package com.godelivery.godelivery.infrastructure.repository;

import com.godelivery.godelivery.domain.model.PaymentMethods;
import com.godelivery.godelivery.domain.repository.PaymentMethodsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PaymentMethodsRepositoryImpl implements PaymentMethodsRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<PaymentMethods> findAll() {
        TypedQuery<PaymentMethods> typedQuery = entityManager.createQuery("from PaymentMethods", PaymentMethods.class);
        return typedQuery.getResultList();
    }

    @Override
    public PaymentMethods findById(Long id) {
        return entityManager.find(PaymentMethods.class, id);
    }

    @Override
    @Transactional
    public PaymentMethods insert(PaymentMethods paymentMethods) {
        return entityManager.merge(paymentMethods);
    }

    @Override
    @Transactional
    public PaymentMethods update(PaymentMethods paymentMethods) {
        return entityManager.merge(paymentMethods);
    }

    @Override
    @Transactional
    public void remove(PaymentMethods paymentMethods) {
        PaymentMethods currentState = this.findById(paymentMethods.getId());
        entityManager.remove(currentState);
    }
}
