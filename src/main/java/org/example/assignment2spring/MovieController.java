package org.example.assignment2spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/movies")
public class MovieController {

    @Autowired
    private MoviesRepository moviesRepository;

    // Retrieve all non-blocked movies
    @GetMapping
    public String getAllNonBlockedMovies(Model model) {
        model.addAttribute("movies", moviesRepository.findByIsBlockedFalse());
        return "movie_page";  // Refers to Thymeleaf template: admin_movies.html
    }

    // Block or unblock a movie by ID
    @PostMapping("/{id}/action")
    @ResponseBody
    public String handleMovieAction(@PathVariable Long id, @RequestParam("action") String action) {
        Movies movie = moviesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        if ("block".equals(action)) {
            movie.blockMovie(); // Block the movie
        } else if ("unblock".equals(action)) {
            movie.unblockMovie(); // Unblock the movie
        }

        moviesRepository.save(movie);  // Save changes to the movie

        return "Movie status updated successfully"; // Return success message
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
