package com.example.admin;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/admin/movies") @Data
public class AdminMoviesController {
    private final AdminMoviesService adminMoviesService;

    public AdminMoviesController(AdminMoviesService adminMoviesService) {
        this.adminMoviesService = adminMoviesService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Movies>> listMovies() {
        List<Movies> movies = adminMoviesService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/blocked")
    public ResponseEntity<List<Movies>> listBlockedMovies() {
        List<Movies> blockedMovies = adminMoviesService.getBlockedMovies();
        return ResponseEntity.ok(blockedMovies);
    }

    @GetMapping("/unblocked")
    public ResponseEntity<List<Movies>> listUnblockedMovies() {
        List<Movies> unblockedMovies = adminMoviesService.getUnblockedMovies();
        return ResponseEntity.ok(unblockedMovies);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<Boolean> checkMovieStatus(@PathVariable Long id) {
        boolean isBlocked = adminMoviesService.isMovieBlocked(id);
        return ResponseEntity.ok(isBlocked);
    }

    @PostMapping("/block/{id}")
    public ResponseEntity<Void> blockMovie(@PathVariable Long id) {
        adminMoviesService.blockMovie(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @PostMapping("/unblock/{id}")
    public ResponseEntity<Void> unblockMovie(@PathVariable Long id) {
        adminMoviesService.unblockMovie(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
