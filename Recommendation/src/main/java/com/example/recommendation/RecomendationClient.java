package com.example.recommendation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "database", url = "http://localhost:8009/recommendation")
public interface RecomendationClient {

    @GetMapping("/get")
    ResponseEntity<Movies> getRecomendation();
}
