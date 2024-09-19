package com.example.screamer;

import jakarta.transaction.Transactional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Anmol Saru Magar
 * File Name: MovieClient.java
 * Date :16/9/2024
 * Purpose :
 * MovieClient that takes request and sends that request to it assigned url
 * ******************************************************
 */
@FeignClient(name = "movie", url = "http://localhost:8009/movies")
@Transactional
public interface MovieClient {

    @GetMapping("/get/all")
    List<Movies> getAllMovies();

    @GetMapping("/get/watchlist/all/{custID}")
    WatchList getAllWatchList(@PathVariable("custID") String custID);

    @PutMapping("/update/{id}")
    Movies updateMovieById(@PathVariable("id") Long id, @RequestBody Movies movie);

    @PostMapping(value = "/add/watchlist/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addMoveToWatchList(@PathVariable("id") Long id, @RequestParam("action") String action, @RequestBody Customer customer);

}
