package com.example.databasedao;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: ??
 * Contributor Caleb Davidson
 * File Name: AdminMoviesController.java
 * Date: 16/9/2024
 * Purpose:
 * service class containing customer related logic
 * ******************************************************
 */

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer postCustomer(Customer customer) {
        System.out.println("Debug: " + customer);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findByBlocked(false);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    Customer getByEmail(String email) {
        return customerRepository.findByemail(email);
    }

}
