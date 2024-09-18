package com.example.databasedao.movies;

import com.example.databasedao.customer.CustomerRepository;
import com.example.databasedao.customer.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * MovieService.java
 * Author: Anmol Saru Magar
 * Date: 16/09/2024
 * Purpose:
 * Provides business logic for movie operations such as adding, removing, updating movies,
 * and managing watch lists.
 */
@Service
public class MovieService {
    private final MoviesRepository movieRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final WatchListRepository watchListRepository;

    private WatchList watchListToAdd = new WatchList();
    private List<Movies> moviesToAdd;

    public MovieService(MoviesRepository movieRepository, CustomerRepository customerRepository,
                        CustomerService customerService, WatchListRepository watchListRepository) {
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.watchListRepository = watchListRepository;
    }

    /**
     * Adds a new movie to the database.
     */
    public Movies postMovie(Movies movie) {
        return movieRepository.save(movie);
    }

    /**
     * Removes a movie from the watch list.
     */
    @Transactional
    public WatchList removeWatchList(Long id) {
        Optional<Movies> movies = movieRepository.findById(id);
        WatchList watchLists = getAllWatchList();
        Movies movieToRemove = movies.get();
        movieToRemove.setInWatchList(false);
        movieRepository.save(movieToRemove);
        watchLists.getMovies().remove(movieToRemove);
        watchListToAdd = watchListRepository.save(watchLists);
        return watchListToAdd;
    }

    /**
     * Adds a movie to the watch list.
     */
    public WatchList postWatchlist(Long id) {
        Movies movie = movieRepository.findById(id).get();
        movie.setInWatchList(true);
        movieRepository.save(movie);
        watchListToAdd.addMovie(movie);
        watchListToAdd.setCustomer(customerService.getCustomerById(1L));
        return watchListRepository.save(watchListToAdd);
    }

    /**
     * Retrieves all movies that are not blocked.
     */
    public List<Movies> getAllMovies() {
        return movieRepository.findByBlocked(false);
    }

    /**
     * Retrieves the first watch list from the database.
     */
    public WatchList getAllWatchList() {
        if (watchListRepository.findAll().isEmpty()) {
            return new WatchList();
        } else {
            return watchListRepository.findAll().getFirst();
        }
    }

    /**
     * Retrieves a movie by its ID.
     */
    public Optional<Movies> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    /**
     * Updates an existing movie by its ID.
     */
    public Movies updateMovie(Long id, Movies movie) {
        Movies existingMovie = movieRepository.findById(id).get();
        existingMovie.setInWatchList(movie.getInWatchList());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setSubGenre(movie.getSubGenre());

        return movieRepository.save(existingMovie);
    }
}
