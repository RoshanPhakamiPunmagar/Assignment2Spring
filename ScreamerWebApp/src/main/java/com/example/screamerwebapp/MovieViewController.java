package com.example.screamerwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/view")
public class MovieViewController {

    private final CustomerService customerService;
    private final MovieService movieService;


    public MovieViewController(CustomerService customerService, MovieService movieService) {
        this.customerService = customerService;
        this.movieService = movieService;
    }

    @GetMapping("/watchlist/all")
    public String getAllWatchlistMovies(Model model) {
        WatchList watchList = movieService.getAllWatchListMovies();
        model.addAttribute("watchlist", watchList);
        return "watchlist";
    }

    @GetMapping("/recommendation")
    public String getRecommendationMovies(Model model) {
        Movies recommendedMovie = movieService.getRecommendation();
        model.addAttribute("recommendation", recommendedMovie);
        return "recommend_page";
    }
    @GetMapping("/all")
    public String getAllMovies(Model model) {
        System.out.println("called herer");
        List<Movies> m = movieService.getAllMovies();
        model.addAttribute("movies", m);
        return "movie_page";
    }

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
