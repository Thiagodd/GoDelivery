package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.City;
import com.godelivery.godelivery.domain.model.Cookery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository {

    List<City> findAll();
    City findById(Long id);
    City insert(City city);
    City update(City city);
    void remove (City city);

}
