package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
