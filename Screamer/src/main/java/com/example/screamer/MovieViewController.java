package com.example.screamer;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/view")
public class MovieViewController {


    private final MovieService movieService;
    //private final MoviesRepository moviesRepository;

    public MovieViewController(MovieService movieService) {
        this.movieService = movieService;
        //this.moviesRepository = moviesRepository;
    }

    @GetMapping("/watchlist/all")
    public String getAllWatchlistMovies(Model model) {
        WatchList watchList = movieService.getAllWatchListMovies();
        model.addAttribute("watchlist", watchList);
        return "watchlist";
    }

    @GetMapping("/all")
    public String getAllMovies(Model model) {
        System.out.println("called herer");
        List<Movies> m = movieService.getAllMovies();
        model.addAttribute("movies", m);
        return "movie_page";
    }
    /*
    @PostMapping("/add/watchlist/{movieId}")
    public String addMovieToWatchlist(@PathVariable("movieId") Long movieId) {
        System.out.println(movieId);
        WatchList updatedMovie = movieService.addToWatchList(movieId);
        return "redirect:/view/all";
    }
    @PostMapping("/remove/watchlist/{movieId}")
    public String removeMovieFromWatchlist(@PathVariable("movieId") Long movieId) {
        movieService.removeFromWatchList(movieId);
        return "redirect:/view/all";
    }
    */
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
