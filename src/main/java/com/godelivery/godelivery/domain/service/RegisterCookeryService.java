package com.godelivery.godelivery.domain.service;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RegisterCookeryService {

    @Autowired
    private CookeryRepository cookeryRepository;

    public Cookery save(Cookery cookery) {
        return cookeryRepository.save(cookery);
    }

    public Cookery update(Cookery cookery) {
        return cookeryRepository.save(cookery);
    }

    public void deleteById(Long id) {
        if (!cookeryRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(">>No Cookery record found with ID %d.", id));
        }
        try {
            cookeryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(">>Cookery with ID %d cannot be deleted as it is currently in use.", id));
        }
    }


}
