package com.godelivery.godelivery.jpa;

import com.godelivery.godelivery.GoDeliveryApplication;
import com.godelivery.godelivery.domain.model.Restaurant;
import com.godelivery.godelivery.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class UpdateRestaurantMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(GoDeliveryApplication.class).web(WebApplicationType.NONE).run(args);
        RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);

        System.out.println(ANSI_GREEN);

        Restaurant toUpdateRestaurant = new Restaurant();
        toUpdateRestaurant.setId(1L);
        toUpdateRestaurant.setName("Sabor do Norte");
        toUpdateRestaurant.setDeliveryFee(new BigDecimal("10"));

        Restaurant updatedRestaurant = restaurantRepository.update(toUpdateRestaurant);

        System.out.printf("%d - %s - %s\n", updatedRestaurant.getId(), updatedRestaurant.getName(), updatedRestaurant.getDeliveryFee());

        System.out.println(ANSI_RESET);
    }
}
