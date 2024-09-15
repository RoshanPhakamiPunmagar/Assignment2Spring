package com.Assignment2Spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Assignment2SpringApplication {

	//main method for start the spirng boot project.
	public static void main(String[] args) {
		SpringApplication.run(Assignment2SpringApplication.class, args);
		log.info("[Assignment2SpringApplication][main] Auth service has been started...");
	}

}
