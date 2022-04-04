package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Springboot0103BookSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot0103BookSsmApplication.class, args);
    }

}
