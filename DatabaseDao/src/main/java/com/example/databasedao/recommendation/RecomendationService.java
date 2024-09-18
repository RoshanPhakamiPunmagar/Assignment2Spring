<<<<<<<< HEAD:DatabaseDao/src/main/java/com/example/databasedao/recommendation/RecomendationService.java
package com.example.databasedao.recommendation;

import com.example.databasedao.movies.MovieService;
import com.example.databasedao.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RecomendationService {

    @Autowired
    private final MovieService movieService;

    Random random = new Random();

    public RecomendationService(MovieService movieService) {
        this.movieService = movieService;
    }

    ResponseEntity<Movies> getRecommendation() {


        Movies randomMovie = getRandomMovie();

        return ResponseEntity.ok(randomMovie);

    }

    Movies getRandomMovie() {
        List<Movies> movies = movieService.getAllMovies();

        return movies.get(random.nextInt(movies.size()));
    }

}
========
package com.example.databasedao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Service
public class RecomendationService {

    @Autowired
    private final MovieService movieService;

    Random random = new Random();

    public RecomendationService(MovieService movieService) {
        this.movieService = movieService;
    }

    ResponseEntity<Movies> getRecommendation() {


        Movies randomMovie = getRandomMovie();

        return ResponseEntity.ok(randomMovie);

    }

    Movies getRandomMovie() {
        List<Movies> movies = movieService.getAllMovies();

        return movies.get(random.nextInt(movies.size()));
    }

}
>>>>>>>> f1a1b85d452a349d67ec6d6127249a55b23179a4:DatabaseDao/src/main/java/com/example/databasedao/RecomendationService.java
