package com.example.recommendation;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping ("/recommendation") @Data
public class RecommendationController {


    private final RecommendationService recommendationService;

    @GetMapping("/get")
    private ResponseEntity<Movies> getRecommendation() {
        Movies recommendedMovie = recommendationService.getRecomendation();
        return ResponseEntity.ok(recommendedMovie);
    }

}
