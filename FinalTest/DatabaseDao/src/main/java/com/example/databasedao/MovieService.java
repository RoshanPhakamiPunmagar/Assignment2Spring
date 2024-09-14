package com.example.databasedao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MoviesRepository movieRepository;

    public MovieService(MoviesRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movies postMovie(Movies movie) {
        return movieRepository.save(movie);
    }

    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movies> getMovieById(Long id) {
        try {
            return movieRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch movie by ID: " + e.getMessage(), e);
        }
    }

    public Movies updateMovie(Long id, Movies movie) {
        System.out.println("124124");
        Movies existingMovie =  movieRepository.findById(id).get();
        System.out.println(existingMovie.getId());
                    // Update the fields as needed
                    existingMovie.setIsWatchList();
                    existingMovie.setDescription(movie.getDescription());
                    existingMovie.setTitle(movie.getTitle());
                    existingMovie.setSubGenre(movie.getSubGenre());
                    System.out.println("Done");

                    // Save the updated movie
                    return movieRepository.save(existingMovie);
                }
    }

