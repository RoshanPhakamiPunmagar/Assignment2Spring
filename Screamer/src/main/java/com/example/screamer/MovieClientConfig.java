package com.example.screamer;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class MovieClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
