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
