package com.godelivery.godelivery.domain.service;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.State;
import com.godelivery.godelivery.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RegisterStateService {

    @Autowired
    private StateRepository stateRepository;

    public State save(State state) {
        return stateRepository.save(state);
    }

    public State update(State state) {
        return stateRepository.save(state);
    }

    public void deleteById(Long id) {
        if (!stateRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(">>No State record found with ID %d.", id));
        }

        try {
            stateRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(">>State with ID %d cannot be deleted as it is currently in use.", id));
        }
    }
}
