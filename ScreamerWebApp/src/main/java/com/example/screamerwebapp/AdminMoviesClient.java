package com.example.screamerwebapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "admin-movies", url = "http://localhost:8007/admin/movies")
interface AdminMoviesClient {

    @GetMapping("/get/all")
    List<Movies> listMovies();

    @GetMapping("/blocked")
    List<Movies> listBlockedMovies();

    @GetMapping("/unblocked")
    List<Movies> listUnblockedMovies();

    @GetMapping("/status/{id}")
    Boolean checkMovieStatus(@PathVariable Long id);

    @PostMapping("/block/{id}")
    ResponseEntity<Void> blockMovie(@PathVariable Long id);

    @PostMapping("/unblock/{id}")
    ResponseEntity<Void> unblockMovie(@PathVariable Long id);
}
