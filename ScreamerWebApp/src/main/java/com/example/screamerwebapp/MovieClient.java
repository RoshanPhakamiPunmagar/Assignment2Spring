package com.example.screamerwebapp;

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
@FeignClient(name = "movie", url = "http://localhost:8003/movies")
public interface MovieClient {
    /**
     *
     * Gets movie based upon user
     * It is done so new user have different movie inWatchList status
     * This prevents screamer from displaying "Remove from Watchlist" even though user have not added anything to watchlist
     * "Remove from Watchlist" is seen when user adds movie to watchlist
     * So each movie displayed might have different watchlist status based upon customer id
     * ******************************************************
     */
    @GetMapping("/get/all")
    List<Movies> getAllMovies(@RequestParam Long customerId);
    /**
     *
     * Gets watchlist depending upon customer id
     * As watchlist differ from user to user
     * This allows db algorithm to assign perticular watchlist to user
     * ******************************************************
     */
    @GetMapping("/get/watchlist/all")
    WatchList getAllWatchListMovies(@RequestParam("custId") Long custId);
    //Updates movie based by id
    @PutMapping("/update/{id}")
    Movies updateMovieById(@PathVariable("id") Long id, @RequestBody Movies movie);
    /**
     *
     * Adds or removes movie from watchlist based upon action
     * ******************************************************
     */
    @PostMapping(value = "/add/watchlist/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addMovieToWatchList(@PathVariable("id") Long id, @RequestParam("action") String action, @RequestBody Long customerId);

}
