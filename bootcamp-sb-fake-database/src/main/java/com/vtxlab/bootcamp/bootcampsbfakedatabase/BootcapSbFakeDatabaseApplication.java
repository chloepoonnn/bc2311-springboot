package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootcapSbFakeDatabaseApplication {

    private static ConfigurableApplicationContext cac;

    public static ConfigurableApplicationContext getSpringContext() {
        return cac;
    }

    public static void main(String[] args) {
        System.out.println("Start app fake database");

        // Spring Context
        cac = SpringApplication.run(BootcapSbFakeDatabaseApplication.class,
                args);

        String[] beans = cac.getBeanDefinitionNames();

        for (String bean : beans) {
            System.out.println("Bean= " + bean);
        }

        System.out.println("End app fake database");
    }

}
