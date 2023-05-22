package com.godelivery.godelivery.jpa;

import com.godelivery.godelivery.GoDeliveryApplication;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InsertCookeryMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(GoDeliveryApplication.class).web(WebApplicationType.NONE).run(args);
        CookeryRepository cookeryRepository = applicationContext.getBean(CookeryRepository.class);

        System.out.println(ANSI_GREEN);

        Cookery toSavedCookery1 = new Cookery();
        toSavedCookery1.setName("Brasileira");
        Cookery toSavedCookery2 = new Cookery();
        toSavedCookery2.setName("Japonesa");

        Cookery savedCookery1 = cookeryRepository.insert(toSavedCookery1);
        Cookery savedCookery2 = cookeryRepository.insert(toSavedCookery2);

        System.out.printf("%d - %s\n", savedCookery1.getId(), savedCookery1.getName());
        System.out.printf("%d - %s\n", savedCookery2.getId(), savedCookery2.getName());

        System.out.println(ANSI_RESET);
    }
}
