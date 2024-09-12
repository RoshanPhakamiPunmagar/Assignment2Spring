package org.example.assignment2spring;

import java.util.List;

public interface CustomerService {

    // Returns a list of all users (blocked and non-blocked)
    List<User> findAllUsers();

    // Get user by their ID
    User getUserById(Long id);

    // Block a user by ID
    void blockUser(Long id);

    // Unblock a user by ID
    void unblockUser(Long id);

    // Fetch all non-blocked movies
    List<Movies> getAllNonBlockedMovies();

    // Fetch movie by ID
    Movies getMovieById(Long id);

    // Block a movie by ID
    void blockMovie(Long id);

    // Unblock a movie by ID
    void unblockMovie(Long id);
}
