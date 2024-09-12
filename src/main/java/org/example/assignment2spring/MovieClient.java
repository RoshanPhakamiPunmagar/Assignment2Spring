package org.example.assignment2spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "movies", url = "http://localhost:5050")
interface MovieClient {

    @GetMapping(value = "/movies/{id}")
    Movies _retrieve(@PathVariable Long id);

    @GetMapping(value = "/allMovies")
    List<Movies> _retrieveAll(Model model);

    @PostMapping(value = "/movies")
    Movies _create(Movies interest);

    @PutMapping(value ="/movies/{id}")
    Movies _update(@PathVariable Long id,Movies movies);
}
