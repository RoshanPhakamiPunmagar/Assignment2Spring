package com.example.recommendation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "database")
public interface RecomendationClient {

    @GetMapping("/recommendation/get")
    ResponseEntity<Movies> getRecomendation();
}
