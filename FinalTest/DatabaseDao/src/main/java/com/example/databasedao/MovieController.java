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

    @GetMapping
    public ResponseEntity<List<Movies>> retrieveAll() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> retrieveId(@PathVariable Long id) {
        Optional<Movies> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/id/{id}")
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
    @PostMapping
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        Movies createdMovie = movieService.postMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }
}
