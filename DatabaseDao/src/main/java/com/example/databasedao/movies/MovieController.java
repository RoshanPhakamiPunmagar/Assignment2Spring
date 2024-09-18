package com.example.databasedao.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Anmol Saru Magar
 * File Name: MovieController.java
 * Date :16/9/2024
 * Purpose :
 * Movie controller that  accepts request from other feign clients
 * All the methods have different functionality
 * ******************************************************
 */
@RestController @RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    // Retrieve all movies from the database
    @GetMapping("/get/all")
    public ResponseEntity<List<Movies>> retrieveAll() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // Retrieve all watch lists from the database
    @GetMapping("/get/watchlist/all")
    public ResponseEntity<WatchList> retrieveAllWatchList() {
        WatchList watchLists = movieService.getAllWatchList();
        return ResponseEntity.ok(watchLists);
    }

    // Retrieve a specific movie by its ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Movies> retrieveId(@PathVariable Long id) {
        Optional<Movies> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a specific movie by its ID
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Movies> updateMovieById(@PathVariable("id") Long id, @RequestBody Movies movie) {
        try {
            Movies updatedMovie = movieService.updateMovie(id, movie);
            return ResponseEntity.ok(updatedMovie);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Add a new movie to the database
    @PostMapping("/add")
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        Movies createdMovie = movieService.postMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    // Add or remove a movie from the watchlist based on the action specified
    @PostMapping("/add/watchlist/{id}")
    public ResponseEntity<WatchList> addMovieToWatchlist(@PathVariable("id") Long id, @RequestParam String action) {
        WatchList updatedMovie = new WatchList();
        if ("Add".equals(action)) {
            updatedMovie = movieService.postWatchlist(id);
        } else if ("Remove".equals(action)) {
            updatedMovie = movieService.removeWatchList(id);
        }
        return ResponseEntity.ok(updatedMovie);
    }

}
