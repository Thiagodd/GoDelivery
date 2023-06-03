package com.godelivery.godelivery.api;

import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.model.Restaurant;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import com.godelivery.godelivery.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CookeryRepository cookeryRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/cookeries/by-name")
    public List<Cookery> cookeriesByName(@RequestParam("name") String name) {
        return cookeryRepository.findByNameContaining(name);
    }

    @GetMapping("/restaurants/by-name2")
    public List<Restaurant> restaurantsByName(@RequestParam("name") String name, @RequestParam Long id) {
        return restaurantRepository.buscarPorNome(name, id);
    }

    @GetMapping("/cookeries/exists-by-name")
    public boolean cookeriesExistsByName(@RequestParam("name") String name) {
        return cookeryRepository.existsByName(name);
    }

    @GetMapping("/restaurants/by-delivery-fee")
    public List<Restaurant> restaurantsByDeliveryFee(@RequestParam("startingFee") BigDecimal startingFee, @RequestParam("endingFee") BigDecimal endingFee) {
        return restaurantRepository.findByDeliveryFeeBetween(startingFee, endingFee);
    }

    @GetMapping("/restaurants/by-name")
    public List<Restaurant> restaurantsByDeliveryFee(@RequestParam("name") String name, @RequestParam("cookeryId") Long cookeryId) {
        return restaurantRepository.findByNameContainingAndCookeryId(name, cookeryId);
    }

    @GetMapping("/restaurants/by-name3")
    public List<Restaurant> restaurantsByDeliveryFee(@RequestParam("name") String name, @RequestParam("startingFee") BigDecimal startingFee, @RequestParam("endingFee") BigDecimal endingFee) {
        return restaurantRepository.findByName3(name, startingFee, endingFee);
    }

    @GetMapping("/restaurants/by-name4")
    public List<Restaurant> restaurantsByDeliveryFee4(String name, BigDecimal startingFee, BigDecimal endingFee) {
        return restaurantRepository.findByName4(name, startingFee, endingFee);
    }

    @GetMapping("/restaurants/by-name5")
    public List<Restaurant> restaurantsByDeliveryFee5(String name, BigDecimal startingFee, BigDecimal endingFee) {
        return restaurantRepository.findByName5(name, startingFee, endingFee);
    }

    @GetMapping("/restaurants/by-first-name")
    public Optional<Restaurant> restaurantByName(@RequestParam("name") String name) {
        return restaurantRepository.findFirstByNameContaining(name);
    }

    @GetMapping("/restaurants/by-name-top2")
    public List<Restaurant> restaurantByNameTop2(@RequestParam("name") String name) {
        return restaurantRepository.findTop2ByNameContaining(name);
    }

    @GetMapping("/restaurants/count-by-cookery")
    public Integer countByCookeryId(@RequestParam("cookeryId") Long cookeryId) {
        return restaurantRepository.countByCookeryId(cookeryId);
    }

    @GetMapping("/restaurants/by-name5─────·")
    public List<Restaurant> restaurantsByName(String name, BigDecimal startingFee, BigDecimal endingFee) {
        return restaurantRepository.findByName4(name, startingFee, endingFee);
    }


}
