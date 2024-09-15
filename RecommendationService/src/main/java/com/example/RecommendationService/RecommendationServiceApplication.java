package com.example.RecommendationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class RecommendationServiceApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder recommendationService = new SpringApplicationBuilder(RecommendationServiceApplication.class);
        recommendationService.properties("server.port=8333");
        recommendationService.properties("spring.application.name=recommendationClient");
        recommendationService.properties("eureka.client.service-url.defaultZone=http://localhost:8761/eureka/");
        recommendationService.properties("eureka.instance.prefer-ip-address=true");
        recommendationService.run(args);
    }

}
