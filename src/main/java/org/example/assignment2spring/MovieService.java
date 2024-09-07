package org.example.assignment2spring;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MoviesRepository moviesRepository;
    private final WatchListRepository watchListRepository;

    public MovieService(MoviesRepository moviesRepository, WatchListRepository watchListRepository) {
        this.moviesRepository = moviesRepository;
        this.watchListRepository = watchListRepository;
    }

    public Movies saveMovies(Movies movies) {
        try {
            return moviesRepository.save(movies);
        } catch (Exception e) {
            // Handle exception or log the error
            throw new RuntimeException("Failed to save movies: " + e.getMessage());
        }
    }

    public List<Movies> getAllMovies() {
        try {
            return moviesRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to save get all movies: " + e.getMessage());
        }
    }
    public List<WatchList> getAllWatchListMovies() {
        try {
            return watchListRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to save get all movies: " + e.getMessage());
        }
    }





    public Optional<Movies> fetchProductById(Long id) {
        try {
            return moviesRepository.findById(id);
        } catch (Exception e) {
            // Handle exception or log the error
            throw new RuntimeException("Failed to fetch movie by ID: " + e.getMessage());
        }
    }

    public WatchList addWatchList(Long id) {
        try {
            Optional<Movies> movie = moviesRepository.findById(id);


            if (movie.isPresent()) {
                Movies movieToAdd = movie.get();
                WatchList wl = new WatchList();
                wl.addMovie(movieToAdd);

                WatchList savedWatchList= watchListRepository.save(wl);

                return savedWatchList;
            }
            return null;
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to add watchlist product: " + e.getMessage());
        }

    }

    public Optional<Movies> updateProduct(Long id, Movies updatedProduct) {
        try {
            Optional<Movies> existingMovieOptional = moviesRepository.findById(id);
            if (existingMovieOptional.isPresent()) {
                Movies existingMovie = existingMovieOptional.get();
                existingMovie.setTitle(updatedProduct.getTitle());
                existingMovie.setUrl(updatedProduct.getUrl());


                Movies savedEntity = moviesRepository.save(existingMovie);
                return Optional.of(savedEntity);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            // Handle exception or log the error
            throw new RuntimeException("Failed to update product: " + e.getMessage());
        }
    }

    public boolean deleteMovie(Long id) {
        try {
            moviesRepository.deleteById(id);
            return true; // Deletion successful
        } catch (Exception e) {
            // Handle exception or log the error
            throw new RuntimeException("Failed to delete product: " + e.getMessage());
        }
    }
}
