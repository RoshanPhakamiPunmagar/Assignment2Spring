package com.example.databasedao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MoviesRepository movieRepository;

    private final CustomerRepository customerRepository;

    private final CustomerService customerService;
    private final WatchListRepository watchListRepository;

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
    public void removeWatchList(Long id, Long customer) {
        Optional<Movies> movies = movieRepository.findById(id);
        WatchList watchLists = getAllWatchList(customer);
        Movies movieToRemove = movies.get();
        movieToRemove.setInWatchList(false);
        movieRepository.save(movieToRemove);
        watchLists.getMovies().remove(movieToRemove);
     watchListRepository.save(watchLists);


    }


    public void postWatchlist(Long id, Long customerId) {
        // Retrieve the movie from the repository
        Movies movie = movieRepository.findById(id).get();

        WatchList watchLists = getAllWatchList(customerId);

        if(watchLists == null) {
            watchLists = new WatchList();
        }

        movie.setInWatchList(true);

        movieRepository.save(movie);
        watchLists.addMovie(movie);

        watchLists.setCustomer(customerService.getCustomerById(customerId));
        System.out.println(movie.getInWatchList());
        // Save the updated watchlist
        watchListRepository.save(watchLists);
    }

    public List<Movies> getAllMovies() {
        System.out.println(movieRepository.findAll());
        return movieRepository.findByBlocked(false);
    }

    public WatchList getAllWatchList(Long id) {
        System.out.println(watchListRepository.findAll().size());
        WatchList wL = new WatchList();
        if (watchListRepository.findByCustomerId(id) == null)
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




    }

