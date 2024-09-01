package org.example.assignment2spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Data
@RequestMapping("/customers")
class CustomerController {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final MoviesRepository moviesRepository;

    @PutMapping("/{customerId}/block/{movieId}")
    @ResponseBody
    public String blockMovieForCustomer(@PathVariable Long customerId, @PathVariable Long movieId) {
        Movies customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Movies movie = moviesRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        customer.blockMovie(movie);
        customerRepository.save(customer);
        return "Movie has been blocked for the customer successfully";
    }

    @PutMapping("/{customerId}/unblock/{movieId}")
    @ResponseBody
    public String unblockMovieForCustomer(@PathVariable Long customerId, @PathVariable Long movieId) {
        Movies customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Movies movie = moviesRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        customer.unblockMovie(movie);
        customerRepository.save(customer);
        return "Movie has been unblocked for the customer successfully";
    }
}
