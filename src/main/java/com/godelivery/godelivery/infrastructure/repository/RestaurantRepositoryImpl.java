package com.godelivery.godelivery.infrastructure.repository;

import com.godelivery.godelivery.domain.model.Restaurant;
import com.godelivery.godelivery.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurant> findAll(){
        return entityManager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    public Restaurant findById(Long id){
        return entityManager.find(Restaurant.class, id);
    }

    @Override
    @Transactional
    public Restaurant insert(Restaurant restaurant){
        return entityManager.merge(restaurant);
    }

    @Override
    @Transactional
    public Restaurant update(Restaurant restaurant){
        return entityManager.merge(restaurant);
    }

    @Override
    @Transactional
    public void remove(Restaurant restaurant){
        restaurant = this.findById(restaurant.getId());
        entityManager.remove(restaurant);
    }
}
