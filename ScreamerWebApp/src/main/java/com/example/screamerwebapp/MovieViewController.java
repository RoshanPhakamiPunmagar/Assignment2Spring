package com.example.screamerwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author Anmol Saru Magar
 * File Name: MovieViewController.java
 * Date :16/9/2024
 * Purpose :
 * MovieViewController a controller that all the user request go through.
 * All the request functionality depends upon
 * ******************************************************
 */
@Controller
@RequestMapping("/view")
public class MovieViewController {

    private final MovieService movieService;
    //Constructor
    public MovieViewController(MovieService movieService) {
        this.movieService = movieService;
    }
    //Gets all the watchlist movies and returns watchlist.html
    @GetMapping("/watchlist/all")
    public String getAllWatchlistMovies(Model model) {
        WatchList watchList = movieService.getAllWatchListMovies();
        model.addAttribute("watchlist", watchList);
        return "watchlist";
    }
    //Gets recommendation and return recommend_page.html
    @GetMapping("/recommendation")
    public String getRecommendationMovies(Model model) {
        Movies recommendedMovie = movieService.getRecommendation();
        model.addAttribute("recommendation", recommendedMovie);
        return "recommend_page";
    }
    //gets all the movies and returns movie_page.html
    @GetMapping("/all")
    public String getAllMovies(Model model) {
        
        List<Movies> m = movieService.getAllMovies();
        System.out.println(m);
        model.addAttribute("movies", m);
        return "movie_page";
    }
    //Adds movie to watchlist and redirects user ot /view/all
    @PostMapping("/add/watchlist/{id}")
    public String addMovieToWatchlist(@PathVariable("id") Long movieId, @RequestParam String action) {

        System.out.println(action);

        if ("Add".equals(action)) {
            movieService.addToWatchList(movieId);
        } else if ("Remove".equals(action)) {
            movieService.removeFromWatchList(movieId);
        }
      return "redirect:/view/all";
    }

}
