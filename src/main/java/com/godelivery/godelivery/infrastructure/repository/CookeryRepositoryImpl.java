package com.godelivery.godelivery.infrastructure.repository;

import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CookeryRepositoryImpl implements CookeryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Cookery> findAll() {
        TypedQuery<Cookery> typedQuery = entityManager.createQuery("from Cookery", Cookery.class);
        return typedQuery.getResultList();
    }

    @Override
    public Cookery findById(Long id) {
        return entityManager.find(Cookery.class, id);
    }

    @Override
    @Transactional
    public Cookery insert(Cookery cookery) {
        return entityManager.merge(cookery);
    }

    @Override
    @Transactional
    public Cookery update(Cookery cookery) {
        return entityManager.merge(cookery);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Cookery currentCookery = this.findById(id);
        if (currentCookery == null) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(currentCookery);
    }
}
