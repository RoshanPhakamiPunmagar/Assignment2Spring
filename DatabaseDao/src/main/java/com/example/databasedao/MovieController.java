package com.example.databasedao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Movies>> retrieveAll() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/get/watchlist/all")
    public ResponseEntity<WatchList> retrieveAllWatchList() {
        WatchList watchLists = movieService.getAllWatchList();
        return ResponseEntity.ok(watchLists);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Movies> retrieveId(@PathVariable Long id) {
        Optional<Movies> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Movies> updateMovieById(@PathVariable("id") Long id, @RequestBody Movies movie) {

        System.out.println(id+  "21xx");
        try {
            System.out.println(id+  "23xx");
            Movies updatedMovie = movieService.updateMovie(id, movie);
            System.out.println(id+  "25xx");
            return ResponseEntity.ok(updatedMovie);
        } catch (RuntimeException e) {
            return null;
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        Movies createdMovie = movieService.postMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @PostMapping("/add/watchlist/{movieId}")
    public ResponseEntity<WatchList> addMovieToWatchlist(@PathVariable("movieId") Long movieId, @RequestParam String action) {
        WatchList updatedMovie = new WatchList();
        if ("Add".equals(action)) {
            updatedMovie    = movieService.postWatchlist(movieId);
        } else if ("Remove".equals(action)) {
            updatedMovie    = movieService.removeWatchList(movieId);
        }
        return ResponseEntity.ok(updatedMovie);
    }
    /*
    @PostMapping("/add/watchlist/{id}")
    @ResponseBody
    public ResponseEntity<WatchList> addWatchList(@PathVariable("id") Long id) {
        System.out.println(id);
        WatchList createdWatchList = movieService.postWatchlist(id);
        return ResponseEntity.ok(createdWatchList);
    }

    @PostMapping("/remove/watchlist/{movieId}")
    @ResponseBody
    public  ResponseEntity<WatchList>  removeMovieFromWatchlist(@PathVariable("movieId") Long id) {
        WatchList createdWatchList = movieService.removeWatchList(id);
        return ResponseEntity.ok(createdWatchList);
    }*/
}
