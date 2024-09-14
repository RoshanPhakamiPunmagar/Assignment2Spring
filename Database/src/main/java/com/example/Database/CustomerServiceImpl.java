package com.example.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    // Fetch all users (both blocked and non-blocked)
    @Override
    public List<Customer> findAllUsers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getUserById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Fetch all non-blocked movies
    @Override
    public List<Movies> getAllNonBlockedMovies() {
        return moviesRepository.findAll();  // Fetch only non-blocked movies
    }

    @Override
    public Movies getMovieById(Long id) {
        return moviesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public void blockUser(Long id) {
        Customer user = getUserById(id);
        user.blockUser();
        customerRepository.save(user);
    }

    @Override
    public void unblockUser(Long id) {
        Customer user = getUserById(id);
        user.unblockUser();
        customerRepository.save(user);
    }

    // Block a movie by ID
    @Override
    public void  blockMovie(Long id) {
        Movies movie = getMovieById(id);
        movie.blockMovie();  // Block the movie (set isBlocked = true)
        moviesRepository.save(movie);
    }

    // Unblock a movie by ID
    @Override
    public void unblockMovie(Long id) {
        Movies movie = getMovieById(id);
        movie.unblockMovie();  // Unblock the movie (set isBlocked = false)
        moviesRepository.save(movie);
    }
}
