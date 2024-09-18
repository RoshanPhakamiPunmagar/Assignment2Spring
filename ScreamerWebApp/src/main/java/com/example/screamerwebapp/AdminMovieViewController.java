package com.example.screamerwebapp;

import feign.FeignException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller @RequestMapping("/admin/movie/view")
public class AdminMovieViewController {

    private final AdminMoviesClient  adminMoviesClient;

    public AdminMovieViewController(AdminMoviesClient adminMoviesClient) {

        this.adminMoviesClient = adminMoviesClient;
    }

    @GetMapping("/all")
    public String listMovies(Model model) {
        List<Movies> movies = adminMoviesClient.listMovies();
        model.addAttribute("movies", movies);
        return "movie-list";
    }

    @GetMapping("/blocked")
    public String listBlockedMovies(Model model) {
        List<Movies> blockedMovies = adminMoviesClient.listBlockedMovies();
        return "redirect:/admin/movie/view/all";
    }

    @GetMapping("/unblocked")
    public String listUnblockedMovies(Model model) {
        List<Movies> unblockedMovies = adminMoviesClient.listUnblockedMovies();
        model.addAttribute("movies", unblockedMovies);
        return "redirect:/admin/movie/view/all";
    }

    @GetMapping("/status/{id}")
    public String checkMovieStatus(@PathVariable Long id, Model model) {
        boolean isBlocked = adminMoviesClient.checkMovieStatus(id);
        model.addAttribute("isBlocked", isBlocked);
        return "movie-status";
    }

    @PostMapping("/block/{id}")
    public String blockMovie(@PathVariable Long id) {
        try {
            adminMoviesClient.blockMovie(id);
        } catch (FeignException e) {
            // Log the Feign exception details
            System.err.println("Feign exception while blocking movie: " + e.getMessage());
        } catch (Exception e) {
            // Log the general exception details
        }
        return "redirect:/admin/movie/view/all";
    }


    @PostMapping("/unblock/{id}")
    public String unblockMovie(@PathVariable Long id) {
        try {
            adminMoviesClient.unblockMovie(id);
        } catch (Exception e) {
            // Log the Feign exception details
            System.err.println("Feign exception while blocking movie: " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/admin/movie/view/all";
    }
}
