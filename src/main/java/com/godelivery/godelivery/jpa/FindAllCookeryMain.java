package com.godelivery.godelivery.jpa;

import com.godelivery.godelivery.GoDeliveryApplication;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class FindAllCookeryMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(GoDeliveryApplication.class).web(WebApplicationType.NONE).run(args);
        CookeryRepository cookeryRepository = applicationContext.getBean(CookeryRepository.class);

        System.out.println(ANSI_GREEN);

        List<Cookery> cookeries = cookeryRepository.findAll();

        for (Cookery cookery : cookeries) {
            System.out.println(cookery.getName());
        }

        System.out.println(ANSI_RESET);
    }
}
