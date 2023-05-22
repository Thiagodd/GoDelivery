package com.godelivery.godelivery.infrastructure.repository;

import com.godelivery.godelivery.domain.model.City;
import com.godelivery.godelivery.domain.repository.CityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<City> findAll() {
        TypedQuery<City> typedQuery = entityManager.createQuery("from City", City.class);
        return typedQuery.getResultList();
    }

    @Override
    public City findById(Long id) {
        return entityManager.find(City.class, id);
    }

    @Override
    @Transactional
    public City insert(City city) {
        return entityManager.merge(city);
    }

    @Override
    @Transactional
    public City update(City city) {
        return entityManager.merge(city);
    }

    @Override
    @Transactional
    public void remove(City city) {
        City currentCity = this.findById(city.getId());
        entityManager.remove(currentCity);
    }
}
