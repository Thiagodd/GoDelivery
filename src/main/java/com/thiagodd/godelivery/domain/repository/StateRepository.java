package com.thiagodd.godelivery.domain.repository;

import com.thiagodd.godelivery.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
