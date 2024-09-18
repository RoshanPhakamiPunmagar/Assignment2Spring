package com.example.databasedao;

import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMoviesService {
    private final MoviesRepository moviesRepository;

    public AdminMoviesService(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    public void blockMovie(Long movieId) {
        try {

            Movies movie = moviesRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
            movie.setBlocked(true);
            moviesRepository.save(movie);
            System.out.println("Movie blocked");
        } catch (FeignException e) {
            // Log specific details of FeignException
            System.err.println("Feign exception while blocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to block movie", e);
        } catch (Exception e) {
            // Log general exceptions
            System.err.println("Exception while blocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to block movie", e);
        }
    }


    public void unblockMovie(Long movieId) {
        try {

            Movies movie = moviesRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
            movie.setBlocked(false);
            moviesRepository.save(movie);
            System.out.println("Movie unblocked");
        } catch (FeignException e) {
            System.err.println("Feign exception while unblocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to unblock movie", e);
        } catch (Exception e) {
            System.err.println("Exception while unblocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to unblock movie", e);
        }
    }

    public boolean isMovieBlocked(Long movieId) {
        try {
            Movies movie = moviesRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
            System.out.println("Movie with ID: " + movieId + " is blocked: " + movie.isBlocked());
            return movie.isBlocked();
        } catch (Exception e) {
            throw new RuntimeException("Failed to check movie status", e);
        }
    }

    public List<Movies> getBlockedMovies() {
        return moviesRepository.findByBlocked(true);
    }

    public List<Movies> getUnblockedMovies() {
        return moviesRepository.findByBlocked(false);
    }

    public List<Movies> getAllMovies() {
        return  moviesRepository.findAll();
    }
}
