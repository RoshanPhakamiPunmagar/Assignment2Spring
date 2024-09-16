package com.example.WebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class WebAppApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder webApp = new SpringApplicationBuilder(WebAppApplication.class);
        webApp.properties("server.port=8080");
        webApp.properties("spring.application.name=recommendationClient");
        webApp.properties("eureka.client.service-url.defaultZone=http://localhost:8761/eureka/");
        webApp.properties("eureka.instance.prefer-ip-address=true");
        webApp.run(args);
    }

}
