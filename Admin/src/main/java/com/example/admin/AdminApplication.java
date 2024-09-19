package com.example.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;


/**
 *
 * @author Roshan Phakami PunMagar
 * File Name: AdminApplication.java
 * Date :16/9/2024
 * Purpose : Runs AdminApplicaiton
 * ******************************************************
 */
//Enable Spring Boot application
@SpringBootApplication
// Enables service discovery for this application
@EnableDiscoveryClient
// Enables Feign clients for making RESTFUL HTTP requests to other services
@EnableFeignClients
public class AdminApplication {

    public static void main(String[] args) {

        // Starts the Spring Boot application
        SpringApplication.run(AdminApplication.class, args);
    }

}
