package org.example.assignment2spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MoviesRepository moviesRepository;


    @Autowired
    private CustomerService customerService;


    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", customerService.getAllUsers());
        return "user";  // Refers to Thymeleaf template: admin_users.html
    }

    @PostMapping("/users/{id}/action")
    public String handleUserAction(@PathVariable Long id, @RequestParam("action") String action) {
        if ("block".equals(action)) {
            customerService.blockUser(id);  // Block the user
        } else if ("unblock".equals(action)) {
            customerService.unblockUser(id);  // Unblock the user
        }
        return "redirect:/admin/users";  // Redirect back to the list of users
    }


    // Block a movie by ID
    @PostMapping("/movies/{id}/block")
    @ResponseBody
    public String blockMovie(@PathVariable Long id) {
        Movies movie = moviesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.blockMovie(); // Block the movie
        moviesRepository.save(movie);
        return "Movie has been blocked successfully";
    }

    // Unblock a movie by ID
    @PostMapping("/movies/{id}/unblock")
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

}
