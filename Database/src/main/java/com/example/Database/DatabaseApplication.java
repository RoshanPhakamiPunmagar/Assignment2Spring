package com.example.Database;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@EnableEurekaServer
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class DatabaseApplication {

    public static void main(String[] args) {
           SpringApplicationBuilder eureka = new SpringApplicationBuilder(DatabaseApplication.class);
        eureka.properties("server.port=8761");
        eureka.properties("eureka.client.register-with-eureka=false");
        eureka.properties("eureka.client.fetch-registry=false");
        eureka.run(args);
        
        SpringApplicationBuilder DatabaseService = new SpringApplicationBuilder(DatabaseApplication.class);
        DatabaseService.properties("server.port=8000");
        // #comment in application.properties
        DatabaseService.properties("spring.application.name=Database");
        DatabaseService.run(args);
    }
}
    
    @Component
@Data
@Transactional
class AppInit implements ApplicationRunner {

   
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create and save movie entries
       
    }
    
}
