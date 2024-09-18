<<<<<<<< HEAD:DatabaseDao/src/main/java/com/example/databasedao/recommendation/RecommendationController.java
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
========
package com.example.databasedao;

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
>>>>>>>> f1a1b85d452a349d67ec6d6127249a55b23179a4:DatabaseDao/src/main/java/com/example/databasedao/RecommendationController.java
