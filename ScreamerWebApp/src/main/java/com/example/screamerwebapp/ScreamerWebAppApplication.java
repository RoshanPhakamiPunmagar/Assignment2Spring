package com.example.screamerwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 *
 * @author Anmol Saru Magar & Roshan Phakami PunMagar
 * File Name: ServerApplication.java
 * Date :16/9/2024
 * Purpose :
 * Runs ScreamerWebAppApplication
 * ******************************************************
 */
@SpringBootApplication @EnableFeignClients
@EnableDiscoveryClient
public class ScreamerWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreamerWebAppApplication.class, args);
    }

}
