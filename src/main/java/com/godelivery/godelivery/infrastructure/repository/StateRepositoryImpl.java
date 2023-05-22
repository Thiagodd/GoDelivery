package com.godelivery.godelivery.infrastructure.repository;

import com.godelivery.godelivery.domain.model.State;
import com.godelivery.godelivery.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<State> findAll() {
        TypedQuery<State> typedQuery = entityManager.createQuery("from State", State.class);
        return typedQuery.getResultList();
    }

    @Override
    public State findById(Long id) {
        return entityManager.find(State.class, id);
    }

    @Override
    @Transactional
    public State insert(State state) {
        return entityManager.merge(state);
    }

    @Override
    @Transactional
    public State update(State state) {
        return entityManager.merge(state);
    }

    @Override
    @Transactional
    public void remove(State state) {
        State currentState = this.findById(state.getId());
        entityManager.remove(currentState);
    }
}
