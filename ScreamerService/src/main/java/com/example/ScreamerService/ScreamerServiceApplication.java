package com.example.ScreamerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ScreamerServiceApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder screamerService = new SpringApplicationBuilder(ScreamerServiceApplication.class);
        screamerService.properties("server.port=8888");
        screamerService.properties("spring.application.name=screamerService");
        screamerService.properties("eureka.client.service-url.defaultZone=http://localhost:8761/eureka/");
        screamerService.properties("eureka.instance.prefer-ip-address=true");
        screamerService.run(args);
    }

}
