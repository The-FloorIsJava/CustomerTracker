package com.revature.CustomerTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication // @EnableAutoConfiguration, @ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CustomerTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTrackerApplication.class, args);
    }

}