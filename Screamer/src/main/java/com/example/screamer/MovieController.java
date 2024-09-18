package com.example.screamer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<WatchList> getAllWatchlistMovies() {
        System.out.println( "xx");
        WatchList movies = movieService.getAllWatchListMovies();
        return ResponseEntity.ok(movies);
    }



    @PostMapping("/add/watchlist/{id}")
    public ResponseEntity<WatchList> addMovieToWatchlist(@PathVariable("id") Long movieId, @RequestParam String action) {

        System.out.println(action);
        WatchList watchList = new WatchList();
        if ("Add".equals(action)) {
            watchList =  movieService.addToWatchList(movieId);
        } else if ("Remove".equals(action)) {
            watchList =     movieService.removeFromWatchList(movieId);
        }
        return ResponseEntity.ok(watchList);
    }

}

   /*
    @PostMapping("/add/watchlist/{id}")
    public ResponseEntity<WatchList> addMovieToWatchlist(@PathVariable("id") Long movieId, @RequestParam String action) {
            action = "Add";
            WatchList watchList = movieService.addToWatchList(movieId);

        return ResponseEntity.ok(watchList);
    }

    @PostMapping("/add/watchlist/{movieId}")
    public ResponseEntity<WatchList> addMovieToWatchlist(@PathVariable("movieId") Long movieId) {
            WatchList updatedMovie = movieService.addToWatchList(movieId);
            return ResponseEntity.ok(updatedMovie);
    }
    */

  /*
    @PostMapping("/add/watchlist/{movieId}")
    public String addMovieToWatchlist(@PathVariable("movieId") Long movieId) {
        System.out.println(movieId);
        WatchList updatedMovie = movieService.addToWatchList(movieId);
        return "redirect:/view/all";
    }
    @PostMapping("/remove/watchlist/{movieId}")
    public String removeMovieFromWatchlist(@PathVariable("movieId") Long movieId) {
        movieService.removeFromWatchList(movieId);
        return "redirect:/view/all";
    }
    */