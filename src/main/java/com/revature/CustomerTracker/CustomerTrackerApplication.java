package com.revature.CustomerTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @EnableAutoConfiguration, @ComponentScan
public class CustomerTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTrackerApplication.class, args);
    }

}