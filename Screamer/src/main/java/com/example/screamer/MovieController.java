package com.example.screamer;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController @RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Movies> updateMovieById(@PathVariable("id") Long id, @ModelAttribute Movies movie) {

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
}
