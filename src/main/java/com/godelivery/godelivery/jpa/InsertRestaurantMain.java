package com.godelivery.godelivery.jpa;

import com.godelivery.godelivery.GoDeliveryApplication;
import com.godelivery.godelivery.domain.model.Restaurant;
import com.godelivery.godelivery.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class InsertRestaurantMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(GoDeliveryApplication.class).web(WebApplicationType.NONE).run(args);
        RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);

        System.out.println(ANSI_GREEN);

        Restaurant toSavedRestaurant1 = new Restaurant();
        toSavedRestaurant1.setName("Sabor Divino");
        toSavedRestaurant1.setDeliveryFee(new BigDecimal("9.5"));
        Restaurant toSavedRestaurant2 = new Restaurant();
        toSavedRestaurant2.setName("Casa do Pastel");
        toSavedRestaurant2.setDeliveryFee(new BigDecimal("10"));

        Restaurant savedRestaurant1 = restaurantRepository.insert(toSavedRestaurant1);
        Restaurant savedRestaurant2 = restaurantRepository.insert(toSavedRestaurant2);

        System.out.printf("%d - %s - %s\n", savedRestaurant1.getId(), savedRestaurant1.getName(), savedRestaurant1.getDeliveryFee());
        System.out.printf("%d - %s - %s\n", savedRestaurant2.getId(), savedRestaurant2.getName(), savedRestaurant2.getDeliveryFee());

        System.out.println(ANSI_RESET);
    }

}
