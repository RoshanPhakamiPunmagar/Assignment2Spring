package com.example.databasedao.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Anmol Saru Magar
 * File Name: CustomerController.java
 * Date :16/9/2024
 * Purpose :
 * CustomerController  that  accepts request from other feign clients
 * All the methods have different functionality
 * ******************************************************
 */
@RestController @RequestMapping("/user")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Retrieve all customers from the database
    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> retrieveAll() {
        List<Customer> movies = customerService.getAllCustomers();
        return ResponseEntity.ok(movies);
    }
    // Retrieve a specific customer by their ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> retrieveById(@RequestParam Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
    // Add a new customer to the database
    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.postCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

}
