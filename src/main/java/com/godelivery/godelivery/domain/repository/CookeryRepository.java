package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.Cookery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookeryRepository extends JpaRepository<Cookery, Long>{

    // repositório orientado a persistence
}
