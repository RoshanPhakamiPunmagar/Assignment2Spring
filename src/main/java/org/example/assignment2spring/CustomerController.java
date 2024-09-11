package org.example.assignment2spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private CustomerService customerService;

    // Display all users (blocked and non-blocked)
    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", customerService.findAllUsers());
        return "user";  // This refers to the Thymeleaf template 'user.html'
    }

    // Retrieve all non-blocked movies
    @GetMapping("/movies")
    public String getAllNonBlockedMovies(Model model) {
        model.addAttribute("movies", customerService.getAllNonBlockedMovies());
        return "admin_movies";  // Refers to Thymeleaf template: admin_movies.html
    }

    // Handle blocking or unblocking users
    @PostMapping("/users/{id}/action")
    public String handleUserAction(@PathVariable Long id, @RequestParam("action") String action) {
        if ("block".equals(action)) {
            customerService.blockUser(id);  // Block the user
        } else if ("unblock".equals(action)) {
            customerService.unblockUser(id);  // Unblock the user
        }
        return "redirect:/admin/users";  // Redirect back to the list of users
    }

    // Create a new user using JSON Data
    @PostMapping("/create")
    @ResponseBody
    public Customer createUser(@RequestBody Customer user) {
        return customerRepository.save(user); // Save the user and return the created entity
    }


    // Handle blocking or unblocking movies
    @PostMapping("/movies/{id}/action")
    public String handleMovieAction(@PathVariable Long id, @RequestParam("action") String action) {
        if ("block".equals(action)) {
            customerService.blockMovie(id);  // Block the movie
        } else if ("unblock".equals(action)) {
            customerService.unblockMovie(id);  // Unblock the movie
        }
        return "redirect:/admin/movies";  // Redirect back to the list of movies
    }

    // Create a new movie
    @PostMapping("/create2")
    @ResponseBody
    public String createMovie(@RequestBody Movies movie) {
        moviesRepository.save(movie);
        return "Movie created successfully";
    }

}


