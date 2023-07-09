package com.thiagodd.godelivery.domain.service;

import com.thiagodd.godelivery.domain.exception.CookeryNotFoundException;
import com.thiagodd.godelivery.domain.exception.EntityInUseException;
import com.thiagodd.godelivery.domain.model.Cookery;
import com.thiagodd.godelivery.domain.repository.CookeryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterCookeryService {

 private final CookeryRepository cookeryRepository;

 public RegisterCookeryService(CookeryRepository cookeryRepository) {
  this.cookeryRepository = cookeryRepository;
 }

 public List<Cookery> findAll() {
  return cookeryRepository.findAll();
 }

 public Cookery findById(Long id) {
  return cookeryRepository.findById(id).orElseThrow(() -> new CookeryNotFoundException(id));
 }

 public Cookery save(Cookery cookery) {
  return cookeryRepository.save(cookery);
 }

 public Cookery update(Cookery newCookery) {
  Cookery currentCookery = findById(newCookery.getId());
  BeanUtils.copyProperties(newCookery, currentCookery, "id");
  return cookeryRepository.save(currentCookery);
 }

 public void deleteById(Long id) {
  if (!cookeryRepository.existsById(id)) {
   throw new CookeryNotFoundException(id);
  }

  try {
   cookeryRepository.deleteById(id);
  } catch (DataIntegrityViolationException e) {
   throw new EntityInUseException(id, "cozinha");
  }
 }


}
