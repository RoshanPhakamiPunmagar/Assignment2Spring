
package com.example.databasedao.customer;


import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MovieService.java
 * Author: Anmol Saru Magar
 * Date: 16/09/2024
 * Purpose:
 * Provides business logic for movie operations such as adding, removing, updating movies,
 * and managing watch lists.
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Save a new customer to the database
    public Customer postCustomer(Customer customer) {
        System.out.println(customer.getId());
        return customerRepository.save(customer);
    }

    // Retrieve all customers who are not blocked
    public List<Customer> getAllCustomers() {
        return customerRepository.findByBlocked(false);
    }

    // Retrieve a specific customer by their ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
