package com.thiagodd.godelivery.api;

import com.thiagodd.godelivery.domain.exception.BusinessException;
import com.thiagodd.godelivery.domain.exception.CookeryNotFoundException;
import com.thiagodd.godelivery.domain.exception.EntityNotFoundException;
import com.thiagodd.godelivery.domain.model.Restaurant;
import com.thiagodd.godelivery.domain.repository.RestaurantRepository;
import com.thiagodd.godelivery.domain.service.RegisterRestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

  private final RestaurantRepository restaurantRepository;

  private final RegisterRestaurantService registerRestaurantService;

  public RestaurantController(RestaurantRepository restaurantRepository, RegisterRestaurantService registerRestaurantService) {
    this.restaurantRepository = restaurantRepository;
    this.registerRestaurantService = registerRestaurantService;
  }

  @GetMapping
  public List<Restaurant> findAll() {
    return restaurantRepository.findAll();
  }

  @GetMapping("/{id}")
  public Restaurant findById(@PathVariable Long id) {
    return registerRestaurantService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Restaurant insert(@RequestBody Restaurant restaurant) {
    try {
      return registerRestaurantService.insert(restaurant);
    } catch (CookeryNotFoundException exception) {
      throw new BusinessException(exception.getMessage());
    }
  }

  @PutMapping("/{id}")
  public Restaurant update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
    try{
      restaurant.setId(id);
      return registerRestaurantService.update(restaurant);
    }catch (CookeryNotFoundException exception){
      throw new BusinessException(exception.getMessage());
    }

  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) {
    registerRestaurantService.deleteById(id);
  }
}
