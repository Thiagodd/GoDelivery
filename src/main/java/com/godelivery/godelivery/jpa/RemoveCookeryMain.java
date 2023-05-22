package com.godelivery.godelivery.jpa;

import com.godelivery.godelivery.GoDeliveryApplication;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class RemoveCookeryMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(GoDeliveryApplication.class).web(WebApplicationType.NONE).run(args);
        CookeryRepository cookeryRepository = applicationContext.getBean(CookeryRepository.class);

        System.out.println(ANSI_GREEN);

        Cookery toRemoveCookery = new Cookery();
        toRemoveCookery.setId(1L);

        cookeryRepository.remove(toRemoveCookery);

        System.out.println(ANSI_RESET);
    }
}
