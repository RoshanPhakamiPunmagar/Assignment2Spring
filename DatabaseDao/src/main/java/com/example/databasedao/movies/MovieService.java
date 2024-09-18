package com.example.databasedao.movies;

import com.example.databasedao.customer.CustomerRepository;
import com.example.databasedao.customer.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service class that provides business logic for movie operations.
 * This class handles interactions with the MovieRepository, CustomerRepository,
 * and WatchListRepository to manage movies and watch lists.
 *
 * @author: Anmol Saru Magar
 */
@Service
public class MovieService {
    private final MoviesRepository movieRepository; // Repository for movie operations
    private final CustomerRepository customerRepository; // Repository for customer operations
    private final CustomerService customerService; // Service for customer-related logic
    private final WatchListRepository watchListRepository; // Repository for watch list operations

    private WatchList watchListToAdd = new WatchList(); // Temporary watch list for adding movies
    private List<Movies> moviesToAdd; // List of movies to be added (not used in current code)

    // Constructor to initialize the repositories and services
    public MovieService(MoviesRepository movieRepository, CustomerRepository customerRepository,
                        CustomerService customerService, WatchListRepository watchListRepository) {
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.watchListRepository = watchListRepository;
    }

    // Add a new movie to the database
    public Movies postMovie(Movies movie) {
        System.out.println(movie.getId()); // Debugging output
        return movieRepository.save(movie); // Save and return the movie
    }

    // Remove a movie from the watch list
    @Transactional // Ensures that the operation is transactional
    public WatchList removeWatchList(Long id) {
        Optional<Movies> movies = movieRepository.findById(id); // Find the movie by ID
        WatchList watchLists = getAllWatchList(); // Get the current watch list
        Movies movieToRemove = movies.get(); // Get the movie to remove
        movieToRemove.setInWatchList(false); // Set the movie's watch list status to false
        movieRepository.save(movieToRemove); // Save the updated movie
        watchLists.getMovies().remove(movieToRemove); // Remove the movie from the watch list
        watchListToAdd = watchListRepository.save(watchLists); // Save the updated watch list
        return watchListToAdd; // Return the updated watch list
    }

    // Add a movie to the watch list
    public WatchList postWatchlist(Long id) {
        Movies movie = movieRepository.findById(id).get(); // Retrieve the movie by ID
        movie.setInWatchList(true); // Set the movie's watch list status to true
        movieRepository.save(movie); // Save the updated movie
        watchListToAdd.addMovie(movie); // Add the movie to the watch list
        watchListToAdd.setCustomer(customerService.getCustomerById(1L)); // Set the customer for the watch list
        System.out.println(movie.getInWatchList()); // Debugging output
        return watchListRepository.save(watchListToAdd); // Save and return the updated watch list
    }

    // Retrieve all movies from the database that are not blocked
    public List<Movies> getAllMovies() {
        System.out.println(movieRepository.findAll()); // Debugging output
        return movieRepository.findByBlocked(false); // Return unblocked movies
    }

    // Retrieve all watch lists from the database
    public WatchList getAllWatchList() {
        System.out.println(watchListRepository.findAll().size()); // Debugging output
        WatchList wL = new WatchList(); // Create a new watch list
        if (watchListRepository.findAll().size() <= 0) {
            return wL; // Return empty watch list if none exist
        } else {
            wL = watchListRepository.findAll().getFirst(); // Get the first watch list
        }
        return wL; // Return the watch list
    }

    // Retrieve a specific movie by its ID
    public Optional<Movies> getMovieById(Long id) {
        try {
            return movieRepository.findById(id); // Return the movie if found
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch movie by ID: " + e.getMessage(), e);
        }
    }

    // Update an existing movie by its ID
    public Movies updateMovie(Long id, Movies movie) {
        System.out.println("124124"); // Debugging output
        Movies existingMovie = movieRepository.findById(id).get(); // Get the existing movie
        System.out.println(existingMovie.getId()); // Debugging output

        // Update the movie's fields
        existingMovie.setInWatchList(movie.getInWatchList());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setSubGenre(movie.getSubGenre());
        System.out.println("Done"); // Debugging output

        return movieRepository.save(existingMovie); // Save and return the updated movie
    }
}
