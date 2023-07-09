package com.thiagodd.godelivery.domain.repository;

import com.thiagodd.godelivery.domain.model.Cookery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookeryRepository extends JpaRepository<Cookery, Long> {

 List<Cookery> findByNameContaining(String name);

 boolean existsByName(String name);
}
