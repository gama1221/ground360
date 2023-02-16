package com.shortestroute.ground360;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ground360Application {
    /**
     * Call the deliveryRouteOptimizationDemo static method to run the method
     * @param args- The entry point for any java application execution
     */
    public static void main(String[] args) {
        SpringApplication.run(Ground360Application.class, args);
        DeliveryRouter.deliveryRouteOptimizationDemo();
    }
}
