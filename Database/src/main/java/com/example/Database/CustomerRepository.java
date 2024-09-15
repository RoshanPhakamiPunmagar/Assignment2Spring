package com.example.Database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
     // Returns a list of all users (blocked and non-blocked)
    List<Customer> findAllUsers();

    // Get user by their ID
    Customer getUserById(Long id);

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