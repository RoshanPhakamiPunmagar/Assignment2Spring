package com.example.screamer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private final MoviesRepository moviesRepository;
    @Autowired
    private final MovieClient movieClient;

    public MovieService(MoviesRepository moviesRepository, MovieClient movieClient) {
        this.moviesRepository = moviesRepository;
        this.movieClient = movieClient;
    }

    public List<Movies> getAllMovies() {
        try {
            List<Movies> movies = movieClient.getAllMovies();
            moviesRepository.saveAll(movies);
            return movies;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

    public Movies updateMovie(Long id, Movies movie) {
        System.out.println("124124");
        System.out.println(id);
        List<Movies> movies = getAllMovies();
        Movies existingMovie = new Movies();
        for (Movies m : movies) {
            if (m.getId() == id) {
                existingMovie = m;
            }
        }

        System.out.println(existingMovie.getId());
        // Update the fields as needed
        existingMovie.setWatchList(true);

        movieClient.updateMovieById(id, existingMovie);
        // Save the updated movie
        return moviesRepository.save(existingMovie);
    }
}

