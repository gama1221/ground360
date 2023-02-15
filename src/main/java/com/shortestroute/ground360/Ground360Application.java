package com.shortestroute.ground360;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootApplication
public class Ground360Application {
    public static void main(String[] args) {
        SpringApplication.run(Ground360Application.class, args);
        DeliveryRouter.deliveryRouteOptimizationDemo();
    }
}