package com.example.screamer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Roshan Phakami Pun Magar & Anmol Saru Magar
 * File Name: MovieViewController.java
 * Date :16/9/2024
 * Purpose :
 * CustomerController a controller that all the user request go through.
 * All the request functionality depends upon
 * ******************************************************
 */
@RestController @RequestMapping("/user")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    //gets the list of customer and return http response
    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> retrieveAll() {
        List<Customer> movies = customerService.getAllCustomers();

        return ResponseEntity.ok(movies);
    }
    //gets customer by id and return http response
    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> retrieveById(@RequestParam Long id) {
        Customer customer =  customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    //gets customer and returns http response
    @GetMapping("/getByEmail/{email}")
    public Customer getByEmail(@RequestParam String email)
    {
        return customerService.getByEmail(email);
    }
}