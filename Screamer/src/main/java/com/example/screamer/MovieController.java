package com.example.screamer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Anmol Saru Magar
 * File Name: MovieController.java
 * Date :16/9/2024
 * Purpose :
 * MovieController a controller that all the user request go through.
 * All the request functionality depends upon
 * All the request return ResposnseEntity type
 * ******************************************************
 */
@RestController @RequestMapping("/movies")
public class MovieController {
    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    //gets all movie based upon user movie status
    @GetMapping("/get/all")
    public ResponseEntity<List<Movies>> getAllMovies(Long customerId) {
        List<Movies> movies = movieService.getAllMovies(customerId);
        return ResponseEntity.ok(movies);
    }
    //gets all the watchlist movies
    @GetMapping("/get/watchlist/all")
    public ResponseEntity<WatchList> getAllWatchlistMovies(@RequestParam("custId") Long custId) {
        WatchList movies = movieService.getAllWatchListMovies(custId);

        return ResponseEntity.ok(movies);
    }
    //adds movie to watchlists
    @PostMapping("/add/watchlist/{id}")
    public void addMovieToWatchlist(@PathVariable("id") Long movieId, @RequestParam String action, @RequestBody Long customerId) {
        if ("Add".equals(action)) {
            movieService.addToWatchList(movieId, customerId);
        } else if ("Remove".equals(action)) {
            movieService.removeFromWatchList(movieId, customerId);
        }

    }

}

