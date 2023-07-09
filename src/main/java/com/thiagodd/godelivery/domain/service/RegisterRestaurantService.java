package com.thiagodd.godelivery.domain.service;

import com.thiagodd.godelivery.domain.exception.EntityInUseException;
import com.thiagodd.godelivery.domain.exception.RestaurantNotFoundException;
import com.thiagodd.godelivery.domain.model.Cookery;
import com.thiagodd.godelivery.domain.model.Restaurant;
import com.thiagodd.godelivery.domain.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RegisterRestaurantService {

 public static final String MSG_RESTAURANT_IN_USE = "Não foi possível excluir o restaurante com o ID %d. A cozinha está em uso e não pode ser deletada no momento.";
 private static final String MSG_RESTAURANT_NOT_FOUND = "Não foi possível encontrar o restaurante com o ID %d. Verifique se o ID fornecido está correto ou entre em contato com o suporte para obter assistência.";
 private final RestaurantRepository restaurantRepository;
 private final RegisterCookeryService registerCookeryService;

 public RegisterRestaurantService(RestaurantRepository restaurantRepository, RegisterCookeryService registerCookeryService) {
  this.restaurantRepository = restaurantRepository;
  this.registerCookeryService = registerCookeryService;
 }

 public Restaurant findById(Long id) {
  return restaurantRepository.findById(id)
      .orElseThrow(() -> new RestaurantNotFoundException(id));
 }

 public Restaurant insert(Restaurant newRestaurant) {
  Cookery cookery = registerCookeryService.findById(newRestaurant.getCookery().getId());

  newRestaurant.setCookery(cookery);
  return restaurantRepository.save(newRestaurant);
 }

 public Restaurant update(Restaurant newRestaurant) {
  Restaurant currentRestaurant = this.findById(newRestaurant.getId());
  Cookery currentCookery = registerCookeryService.findById(newRestaurant.getCookery().getId());

  BeanUtils.copyProperties(newRestaurant, currentRestaurant, "id", "paymentMethods", "Address", "creationTimestamp");
  currentRestaurant.setCookery(currentCookery);
  return restaurantRepository.save(currentRestaurant);
 }

 public void deleteById(Long id) {
  if (!restaurantRepository.existsById(id)) {
   throw new RestaurantNotFoundException(id);
  }

  try {
   restaurantRepository.deleteById(id);
  } catch (DataIntegrityViolationException e) {
   throw new EntityInUseException(id, "restaurante");
  }
 }


}
