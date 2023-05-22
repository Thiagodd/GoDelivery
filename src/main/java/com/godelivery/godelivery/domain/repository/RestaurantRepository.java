package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository {

    List<Restaurant> findAll();
    Restaurant findById(Long id);
    Restaurant insert(Restaurant restaurant);
    Restaurant update(Restaurant restaurant);
    void remove(Restaurant restaurant);

    // repositório orientado a persistence
}
