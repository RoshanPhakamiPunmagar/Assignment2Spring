package com.example.RecommendationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RecommendationServiceApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder recommendationService = new SpringApplicationBuilder(RecommendationServiceApplication.class);
        recommendationService.properties("server.port=8001");
        recommendationService.properties("spring.application.name=dog1");
        recommendationService.run(args);
    }

}
