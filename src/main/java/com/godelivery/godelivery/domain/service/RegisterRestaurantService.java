package com.godelivery.godelivery.domain.service;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.model.Restaurant;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import com.godelivery.godelivery.domain.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CookeryRepository cookeryRepository;

    public Restaurant save(Restaurant restaurant) {
        Cookery cookery = cookeryExists(restaurant.getCookery().getId());
        restaurant.setCookery(cookery);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Long id, Restaurant restaurant) {
        Cookery existingCookery = cookeryExists(restaurant.getCookery().getId());
        Restaurant existingRestaurant = restaurantExists(id);

        BeanUtils.copyProperties(restaurant, existingRestaurant, "id");
        existingRestaurant.setCookery(existingCookery);
        return restaurantRepository.save(existingRestaurant);
    }

    public void deleteById(Long id) {
        restaurantExists(id);
        try {
            restaurantRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(">>Restaurant with code %d cannot be deleted as it is in use.", id));
        }
    }

    private Cookery cookeryExists(Long id){
        return findEntityById(id, cookeryRepository, "Cookery");
    }

    private Restaurant restaurantExists(Long id) {
        return findEntityById(id, restaurantRepository, "Restaurant");
    }

    private <T> T findEntityById(Long id, JpaRepository<T, Long> repository, String entityName) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No %s record found with ID %d.", entityName, id)
                ));
    }




}
