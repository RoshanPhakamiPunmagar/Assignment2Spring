package com.example.screamerwebapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "movie", url = "http://localhost:8003/movies")
public interface MovieClient {

    @GetMapping("/get/all")
    List<Movies> getAllMovies();

    @GetMapping("/get/watchlist/all")
    WatchList getAllWatchListMovies();

    @PutMapping("/update/{id}")
    Movies updateMovieById(@PathVariable("id") Long id, @RequestBody Movies movie);

    @PostMapping("/add/watchlist/{id}")
    WatchList addMoveToWatchList(@PathVariable("id") Long id, @RequestParam String action);

}
