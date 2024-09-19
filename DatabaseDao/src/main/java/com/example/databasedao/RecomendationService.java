package com.example.databasedao;

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
