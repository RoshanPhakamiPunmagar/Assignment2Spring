package com.example.screamerwebapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 *
 * @author Anmol Saru Magar
 * File Name: WebConfig.java
 * Date :16/9/2024
 * Purpose :
 * Configuring ScreamerApp web controller
 * ******************************************************
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/view/");
        registry.addViewController("/login").setViewName("login");
    }
}
