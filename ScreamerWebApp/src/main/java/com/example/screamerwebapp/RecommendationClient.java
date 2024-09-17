package com.example.screamerwebapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "recommendation", url = "http://localhost:8001/recommendation")
public interface RecommendationClient {

    @GetMapping("/get")
    ResponseEntity<Movies> getRecomendation();
}
