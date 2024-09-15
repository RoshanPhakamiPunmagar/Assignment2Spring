package org.example.assignment2spring.recomendation;

import org.example.assignment2spring.Assignment2SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class Recomendation {
    public static void main(String[] args) {

            // Create and run Recommendation service
            SpringApplicationBuilder recommendationApp = new SpringApplicationBuilder(org.example.assignment2spring.Assignment2SpringApplication.class);
            recommendationApp.properties(
                    "server.port=8333",
                    "spring.application.name=RecommendationService",
                    "eureka.client.service-url.defaultZone=http://localhost:8761/eureka/",
                    "eureka.instance.prefer-ip-address=true"
            );
            recommendationApp.build().run(args);  // Run Recommendation service on port 8333
        }
    }


