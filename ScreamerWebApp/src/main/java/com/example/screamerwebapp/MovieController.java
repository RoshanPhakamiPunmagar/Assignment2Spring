package com.example.screamerwebapp;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController @RequestMapping("/movies")
public class MovieController {
    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get/watchlist/all")
    public ResponseEntity<WatchList> getAllWatchlistMovies() {
        System.out.println( "xx");
        WatchList movies = movieService.getAllWatchListMovies();
        return ResponseEntity.ok(movies);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Movies> updateMovieById(@PathVariable("id") Long id, @ModelAttribute Movies movie) {

        System.out.println(id + "21xx");
        try {
            System.out.println(id + "23xx");
            Movies updatedMovie = movieService.updateMovie(id, movie);
            System.out.println(id + "25xx");
            return ResponseEntity.ok(updatedMovie);
        } catch (RuntimeException e) {
            return null;
        }
    }

    //Below methods holds view and talks with screamer web app
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
*/
   /*
    @PostMapping("/add/watchlist/{id}")
    public ResponseEntity<WatchList> addMovieToWatchlist(@PathVariable("id") Long movieId, @RequestParam String action) {
            action = "Add";
            WatchList watchList = movieService.addToWatchList(movieId);

        return ResponseEntity.ok(watchList);
    }

    @PostMapping("/add/watchlist/{movieId}")
    public ResponseEntity<WatchList> addMovieToWatchlist(@PathVariable("movieId") Long movieId) {
            WatchList updatedMovie = movieService.addToWatchList(movieId);
            return ResponseEntity.ok(updatedMovie);
    }
    */

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