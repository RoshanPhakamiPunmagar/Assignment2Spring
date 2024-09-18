package com.example.screamer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer", url = "http://localhost:8009/user")
public interface CustomerClient {

    @GetMapping("/get/all")
    List<Customer> getAllCustomer();


    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> retrieveById(@RequestParam Long id);
    
     @GetMapping("/getByEmail/{email}")
     public Customer getByEmail(@RequestParam String email);

    // Uncomment and update this method if needed
    // @PostMapping("/remove/watchlist/{id}")
    // WatchList removeWatchList(@PathVariable("id") Long id);
}
