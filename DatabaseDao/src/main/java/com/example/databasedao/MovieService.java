package com.example.databasedao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MoviesRepository movieRepository;

    private final CustomerRepository customerRepository;

    private final CustomerService customerService;
    private final WatchListRepository watchListRepository;
    private WatchList watchListToAdd = new WatchList();
    private List<Movies> moviesToAdd;


    public MovieService(MoviesRepository movieRepository, CustomerRepository customerRepository, CustomerService customerService, WatchListRepository watchListRepository) {
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.watchListRepository = watchListRepository;

    }

    public Movies postMovie(Movies movie) {
        System.out.println(movie.getId());
        return movieRepository.save(movie);
    }


    @Transactional
    public WatchList removeWatchList(Long id) {
        Optional<Movies> movies = movieRepository.findById(id);
        WatchList watchLists = getAllWatchList();

        Movies movieToRemove = movies.get();
        movieToRemove.setInWatchList(false);



        movieRepository.save(movieToRemove);
        watchLists.getMovies().remove(movieToRemove);
     watchListToAdd = watchListRepository.save(watchLists);
        // Remove the movie from the watch list's movie list

            //moviesToAdd.remove(movie);


            return watchListToAdd;

    }





    public WatchList postWatchlist(Long id) {
        // Retrieve the movie from the repository
        Movies movie = movieRepository.findById(id).get();


        movie.setInWatchList(true);

        movieRepository.save(movie);
        watchListToAdd.addMovie(movie);

        watchListToAdd.setCustomer(customerService.getCustomerById(1L));
        System.out.println(movie.getInWatchList());
        // Save the updated watchlist
        return watchListRepository.save(watchListToAdd);
    }

    public List<Movies> getAllMovies() {
        System.out.println(movieRepository.findAll());
        return movieRepository.findByBlocked(false);
    }

    public WatchList getAllWatchList() {
        System.out.println(watchListRepository.findAll().size());
        WatchList wL = new WatchList();
        if (watchListRepository.findAll().size() <= 0)
        {
            return wL;
        }
        else {
            wL = watchListRepository.findAll().getFirst();
        }
        return wL;
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
                    existingMovie.setInWatchList(movie.getInWatchList());
                    existingMovie.setDescription(movie.getDescription());
                    existingMovie.setTitle(movie.getTitle());
                    existingMovie.setSubGenre(movie.getSubGenre());
                    System.out.println("Done");

                    // Save the updated movie
                    return movieRepository.save(existingMovie);
                }



    }

