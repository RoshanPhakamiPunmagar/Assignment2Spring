package com.example.screamer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Anmol Saru Magar
 * File Name: MovieViewController.java
 * Date :16/9/2024
 * Purpose :
 * MovieViewController a controller that all the user request go through.
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

    @GetMapping("/get/all")
    public ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get/watchlist/all")
    public ResponseEntity<WatchList> getAllWatchlistMovies(@RequestParam("custId") Long custId) {
        System.out.println("custId: " + custId);
        System.out.println( "xx");
        WatchList movies = movieService.getAllWatchListMovies(custId);

        return ResponseEntity.ok(movies);
    }



    @PostMapping("/add/watchlist/{id}")
    public void addMovieToWatchlist(@PathVariable("id") Long movieId, @RequestParam String action, @RequestBody Long customerId) {

        System.out.println(action);
        WatchList watchList = new WatchList();
        if ("Add".equals(action)) {
            movieService.addToWatchList(movieId, customerId);
        } else if ("Remove".equals(action)) {
            movieService.removeFromWatchList(movieId, customerId);
        }

    }

}

