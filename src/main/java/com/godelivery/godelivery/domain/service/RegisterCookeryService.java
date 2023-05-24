package com.godelivery.godelivery.domain.service;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RegisterCookeryService {

    @Autowired
    private CookeryRepository cookeryRepository;

    public Cookery insert(Cookery cookery){
        return cookeryRepository.insert(cookery);
    }

    public Cookery update(Cookery cookery){
        return cookeryRepository.update(cookery);
    }

    public void deleteById(Long id){
        try {
            cookeryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException(String.format(">>There is no Cookery record with id %d", id));
        }
        catch (DataIntegrityViolationException e){
            throw new EntityInUseException(String.format(">>Cookery with code %d cannot be deleted as it is in use.", id));
        }
    }






}
