package com.example.Database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder DatabaseService = new SpringApplicationBuilder(DatabaseApplication.class);
        DatabaseService.properties("server.port=8001");
        // #comment in application.properties
        DatabaseService.properties("spring.application.name=Database");
        DatabaseService.run(args);
    }

}
