package com.example.screamer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient (name = "movie", url = "http://localhost:8009/movies", configuration = MovieClientConfig.class)
interface MovieClient {

    @GetMapping
    List<Movies> getAllMovies();

    @PutMapping("/id/{id}")
    Movies updateMovieById(@RequestParam("id") Long id, @RequestBody Movies movie);
}
