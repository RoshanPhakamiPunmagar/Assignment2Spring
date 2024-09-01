package org.example.assignment2spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
class AdminController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    // Block a user by ID
    @PutMapping("/users/{id}/block")
    @ResponseBody
    public String blockUser(@PathVariable Long id) {
        Customer user = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.blockUser(); // Block the user
        customerRepository.save(user);
        return "User has been blocked successfully";
    }

    // Unblock a user by ID
    @PutMapping("/users/{id}/unblock")
    @ResponseBody
    public String unblockUser(@PathVariable Long id) {
        Customer user = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.unblockUser(); // Unblock the user
        customerRepository.save(user);
        return "User has been unblocked successfully";
    }

    // Block a movie by ID
    @PutMapping("/movies/{id}/block")
    @ResponseBody
    public String blockMovie(@PathVariable Long id) {
        Movies movie = moviesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.blockMovie(); // Block the movie
        moviesRepository.save(movie);
        return "Movie has been blocked successfully";
    }

    // Unblock a movie by ID
    @PutMapping("/movies/{id}/unblock")
    @ResponseBody
    public String unblockMovie(@PathVariable Long id) {
        Movies movie = moviesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.unblockMovie(); // Unblock the movie
        moviesRepository.save(movie);
        return "Movie has been unblocked successfully";
    }

    // Create a new user
    @PostMapping("/create")
    @ResponseBody
    public Customer createUser(@RequestBody Customer user) {
        return customerRepository.save(user); // Use the injected instance to save the user
    }

    @GetMapping("/users")
    @ResponseBody
    public List<Customer> getAllUsers() {
        return customerRepository.findByIsBlockedFalse(); // Fetch only non-blocked users
    }

}
