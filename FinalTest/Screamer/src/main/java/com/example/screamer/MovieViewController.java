package com.example.screamer;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@Data @RequestMapping("/view")
public class MovieViewController {

    private final MovieService movieService;

    @GetMapping("all")
    public String getAllMovies(Model model) {
        List<Movies> m  = movieService.getAllMovies();
        model.addAttribute("movies", m);
        return "movie_page";
    }


}
