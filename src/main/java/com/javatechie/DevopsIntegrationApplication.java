package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevopsIntegrationApplication {

    @GetMapping
    public String message() {

         return "SringBoot Hello World";
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        SpringApplication.run(DevopsIntegrationApplication.class, args);
    }

}
