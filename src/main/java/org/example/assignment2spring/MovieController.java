package org.example.assignment2spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller @Data
@RequestMapping
class MovieController {
    @Autowired
    private final MoviesRepository moviesRepository;

    @GetMapping("/movies/{id}")
    public String _retrieve(@PathVariable Long id, Model model) {
        Movies m = moviesRepository.findById(id).orElseThrow();
        model.addAttribute("movie", m);
    return "movie_page" ;   }

    @PostMapping("/movies")
    @ResponseBody
    public String _create(@ModelAttribute Movies movies) {
        moviesRepository.save(movies);
        return "C<a href='/index.html'>Movie</a>";
    }

    @PutMapping("/movies")
    @ResponseBody
    public String _update(@PathVariable Long id, @ModelAttribute Movies movies) {
        Movies existingMovie = moviesRepository.findById(id).orElseThrow();
        existingMovie.setTitle(movies.getTitle());
        existingMovie.setUrl(movies.getUrl());
        moviesRepository.save(existingMovie); // Save the updated movie
        return "U<a href='/index.html'>Movie</a>";
    }
}
