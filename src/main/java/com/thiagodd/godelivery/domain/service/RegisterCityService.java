package com.thiagodd.godelivery.domain.service;

import com.thiagodd.godelivery.domain.exception.CityNotFoundException;
import com.thiagodd.godelivery.domain.exception.EntityInUseException;
import com.thiagodd.godelivery.domain.model.City;
import com.thiagodd.godelivery.domain.model.State;
import com.thiagodd.godelivery.domain.repository.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterCityService {

 private final CityRepository cityRepository;

 private final RegisterStateService registerStateService;

 public RegisterCityService(CityRepository cityRepository, RegisterStateService registerStateService) {
  this.cityRepository = cityRepository;
  this.registerStateService = registerStateService;
 }

 public List<City> findAll() {
  return cityRepository.findAll();
 }


 public City findById(Long id) {
  return cityRepository.findById(id)
      .orElseThrow(() -> new CityNotFoundException(id));
 }

 public City save(City newCity) {
  State state = registerStateService.findById(newCity.getState().getId());

  newCity.setState(state);
  return cityRepository.save(newCity);
 }

 public City update(City newCity) {
  City currentCity = findById(newCity.getId());
  State currentState = registerStateService.findById(newCity.getState().getId());

  BeanUtils.copyProperties(newCity, currentCity, "id");
  currentCity.setState(currentState);
  return cityRepository.save(currentCity);
 }

 public void deleteById(Long id) {
  if (!cityRepository.existsById(id)) {
   throw new CityNotFoundException(id);
  }

  try {
   cityRepository.deleteById(id);
  } catch (DataIntegrityViolationException e) {
   throw new EntityInUseException(id, "cidade");
  }
 }
}
