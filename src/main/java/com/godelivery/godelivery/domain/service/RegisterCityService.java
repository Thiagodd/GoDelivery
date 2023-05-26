package com.godelivery.godelivery.domain.service;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.City;
import com.godelivery.godelivery.domain.model.State;
import com.godelivery.godelivery.domain.repository.CityRepository;
import com.godelivery.godelivery.domain.repository.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterCityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;


    public City save(City newCity) {
        State state = statesExists(newCity.getState().getId());
        newCity.setState(state);
        return cityRepository.save(newCity);
    }

    public City update(Long id, City newCity){
        City existingCity = cityExists(id);
        State existingState = statesExists(newCity.getState().getId());

        BeanUtils.copyProperties(newCity, existingCity, "id");
        existingCity.setState(existingState);
        return cityRepository.save(existingCity);
    }

    public void deleteById(Long id){
        cityExists(id);
        try{
            cityRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new EntityInUseException(String.format(">>City with code %d cannot be deleted as it is in use.", id));
        }
    }

    private State statesExists(Long id){
        return findEntityById(id, stateRepository, "State");
    }

    private City cityExists(Long id) {
        return findEntityById(id, cityRepository, "City");
    }

    private <T> T findEntityById(Long id, JpaRepository<T, Long> repository, String entityName) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No %s record found with ID %d.", entityName, id)
                ));
    }

}
