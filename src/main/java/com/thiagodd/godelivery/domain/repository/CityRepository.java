package com.thiagodd.godelivery.domain.repository;

import com.thiagodd.godelivery.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
