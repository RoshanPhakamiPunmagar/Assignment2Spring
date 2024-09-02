package org.example.assignment2spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MovieController {
    @Autowired
    private MoviesRepository moviesRepository;

    // Retrieve all non-blocked movies
    @GetMapping("/movies")
    @ResponseBody
    public List<Movies> getAllNonBlockedMovies() {
        return moviesRepository.findByIsBlockedFalse();
    }

    // Retrieve a movie by ID
    @GetMapping("/{id}")
    @ResponseBody
    public Movies getMovieById(@PathVariable Long id) {
        return moviesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    // Create a new movie
    @PostMapping
    @ResponseBody
    public String createMovie(@RequestBody Movies movie) {
        moviesRepository.save(movie);
        return "Movie created successfully";
    }

    // Update an existing movie
    @PutMapping("/{id}")
    @ResponseBody
    public String _update(@PathVariable Long id, @RequestBody Movies updatedMovie) {
        Movies existingMovie = moviesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setUrl(updatedMovie.getUrl());
        moviesRepository.save(existingMovie);
        return "Movie updated successfully";
    }


}
