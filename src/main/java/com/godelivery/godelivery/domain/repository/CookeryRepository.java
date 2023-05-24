package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.Cookery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookeryRepository {

    List<Cookery> findAll();
    Cookery findById(Long id);
    Cookery insert(Cookery cookery);
    Cookery update(Cookery cookery);
    void deleteById(Long id);

    // repositório orientado a persistence
}
