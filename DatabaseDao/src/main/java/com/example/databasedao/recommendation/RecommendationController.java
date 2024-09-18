package com.example.databasedao.recommendation;

import com.example.databasedao.movies.Movies;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController@Data @RequestMapping("/recommendation")
public class RecommendationController {

    @Autowired
    private final RecomendationService recommendationService;

    @GetMapping("/get")
    @ResponseBody
        // can return webpage in stead
    ResponseEntity<Movies> getRecommendation() {

        Movies recommendation = recommendationService.getRecommendation().getBody();

        return ResponseEntity.ok(recommendation);

    }
}
