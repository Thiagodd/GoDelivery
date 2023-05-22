package com.godelivery.godelivery.jpa;

import com.godelivery.godelivery.GoDeliveryApplication;
import com.godelivery.godelivery.domain.model.Restaurant;
import com.godelivery.godelivery.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class FindRestaurantMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(GoDeliveryApplication.class).web(WebApplicationType.NONE).run(args);
        RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);

        System.out.println(ANSI_GREEN);

        Restaurant savedRestaurant = restaurantRepository.findById(1L);
        System.out.printf("%d - %s\n", savedRestaurant.getId(), savedRestaurant.getName());

        System.out.println(ANSI_RESET);
    }
}
