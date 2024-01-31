package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo41Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo41Application.class, args);
        System.out.println("http://localhost:8080/home");
    }

}
