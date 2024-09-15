package com.example.screamer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient (name = "movie", url = "http://localhost:8009/movies", configuration = MovieClientConfig.class)
interface MovieClient {

    @GetMapping("/get/all")
    List<Movies> getAllMovies();

    @GetMapping("/get/watchlist/all")
    WatchList getAllWatchList();

    @PutMapping("/update/{id}")
    Movies updateMovieById(@RequestParam("id") Long id, @RequestBody Movies movie);

    @PostMapping("/add/watchlist/{id}")
    WatchList addWatchList(@RequestParam("id") Long id, @RequestParam String action);

    //@PostMapping("/remove/watchlist/{id}")
    //WatchList removeWatchList(@RequestParam("id") Long id);
}
