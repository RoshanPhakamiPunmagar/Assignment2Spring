package com.example.databasedao;


import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * @author Roshan Phakami Pun Magar & Anmol Saru Magar
 * File Name: CustomerService.java
 * Date :16/9/2024
 * Purpose :
 * CustomerService that takes requests from its corres
 * Some of the return data are defined
 * ******************************************************
 */

@Service
public class CustomerService {
    //Initizlizing customer repository
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    //enters customer data
    public Customer postCustomer(Customer customer) {
        System.out.println(customer.getId());
        return customerRepository.save(customer);
    }
    //returns all the customer data
    public List<Customer> getAllCustomers() {
        return customerRepository.findByBlocked(false);
    }
    //returns customer by Id
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
    //returns customer by email
    Customer getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
