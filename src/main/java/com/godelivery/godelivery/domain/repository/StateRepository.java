package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.State;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository {

    List<State> findAll();
    State findById(Long id);
    State insert(State state);
    State update(State state);
    void remove (State state);

}
