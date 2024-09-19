package com.example.databasedao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        System.out.println(movies.get(0).getInWatchList());
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get/watchlist/all")
    public ResponseEntity<WatchList> retrieveAllWatchList(@RequestParam("custId") Long id) {
        System.out.println(("custId") +id);
        WatchList watchLists = movieService.getAllWatchList(id);
        return ResponseEntity.ok(watchLists);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Movies> retrieveId(@PathVariable Long id) {
        Optional<Movies> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        Movies createdMovie = movieService.postMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @PostMapping(value = "/add/watchlist/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMovieToWatchlist(@PathVariable("id") Long id, @RequestParam String action, @RequestBody Long customerId) {
        WatchList updatedMovie = new WatchList();
        if ("Add".equals(action)) {
            movieService.postWatchlist(id, customerId);
        } else if ("Remove".equals(action)) {
            movieService.removeWatchList(id, customerId);
        }

    }

}
