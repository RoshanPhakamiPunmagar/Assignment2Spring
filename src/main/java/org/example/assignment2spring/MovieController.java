package org.example.assignment2spring;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller @Data
@RequestMapping
class MovieController {

    private MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movies> retrieve(@PathVariable Long id) {
        Optional<Movies> moviesOptional = movieService.fetchMovieById(id);

        return moviesOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()) ;   }



    @GetMapping("/movies")
    public ResponseEntity<List<Movies>> retrieveAll(Model model) {
        List<Movies> m = movieService.getAllMovies();
        return ResponseEntity.ok(m);   }


    @PostMapping("/movies")
    @ResponseBody
    public ResponseEntity<Movies> create(@RequestBody Movies movies) {
        Movies savedMoveies= movieService.saveMovies(movies);
        return ResponseEntity.ok(savedMoveies);
    }

    @PutMapping("/movies/{id}")
    @ResponseBody
    public ResponseEntity<Movies> update(@PathVariable Long id,@RequestBody Movies movies) {
        Optional<Movies> updateProduct = movieService.updateProduct(id, movies);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()) ;
    }

    @PostMapping("/movies/{id}/removeOrAddToWatchList")
    public String removeOrAddToWatchList(@PathVariable Long id) {
        movieService.addOrRemoveFromWatchList(id);
        return "redirect:/allMovies";
    }


    @GetMapping("/allMovies")
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movie_page";
    }

    @GetMapping("/watchlist")
    public String showWatchList(Model model) {
        List<WatchList> watchLists = movieService.getAllWatchListMovies();  // Fetch the watchlists with movies
        model.addAttribute("watchlist", watchLists);  // Pass the list of watchlists to the template
        return "watchlist";  // Name of the Thymeleaf template
    }

/**
    @RequestMapping(value="/addWatchList")
    public void addWatchListMethod() {
        addWatchList(m1.getId(),m1);
    }**/
}
