package com.example.screamerwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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
    private final CustomerClient customerClient;
    String username;
    //Constructor
    public MovieViewController(MovieService movieService, CustomerClient customerClient) {
        this.movieService = movieService;
        this.customerClient = customerClient;


    }

    //Gets all the watchlist movies and returns watchlist.html
    @GetMapping("/watchlist/all")
    public String getAllWatchlistMovies(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        long custId = customerClient.getByEmail(username).getId();

        WatchList watchList = movieService.getAllWatchListMovies(custId);
        model.addAttribute("watchlist", watchList);
        return "watchlist";
    }
    //return index html
    @GetMapping("/")
    public String getIndex() {
        return "index";
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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        long cust = customerClient.getByEmail(username).getId();
        List<Movies> m = movieService.getAllMovies(cust);
        model.addAttribute("movies", m);
        return "movie_page";
    }

    //Adds movie to watchlist and redirects user ot /view/all
    @PostMapping("/add/watchlist/{id}")
    public String addMovieToWatchlist(@PathVariable("id") Long movieId, @RequestParam String action) {
        long cust = customerClient.getByEmail(username).getId();

        if ("Add".equals(action)) {
            movieService.addToWatchList(movieId, cust);
        } else if ("Remove".equals(action)) {
            movieService.removeFromWatchList(movieId, cust);
        }
        return "redirect:/view/all";
    }

}

