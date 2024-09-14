package org.example.assignment2spring.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class Admin {
    public static void main(String[] args) {

        // Create and run Recommendation service
        SpringApplicationBuilder adminApp = new SpringApplicationBuilder(org.example.assignment2spring.Assignment2SpringApplication.class);
        adminApp.properties(
                "server.port=8338",
                "spring.application.name=AdminService",
                "eureka.client.service-url.defaultZone=http://localhost:8761/eureka/",
                "eureka.instance.prefer-ip-address=true"
        );
        adminApp.build().run(args);
    }
}