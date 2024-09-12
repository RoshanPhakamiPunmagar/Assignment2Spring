package org.example.assignment2spring.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaServer
public class Server {

    public static void main(String[] args) {
        SpringApplicationBuilder eureka = new SpringApplicationBuilder(Server.class);
        eureka.properties("server.port=8761");
        eureka.properties("eureka.client.register-with-eureka=false");
        eureka.properties("eureka.client.fetch-registry=false");
        eureka.run(args);
    }
}
