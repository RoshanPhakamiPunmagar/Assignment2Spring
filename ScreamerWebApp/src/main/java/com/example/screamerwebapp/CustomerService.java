package com.example.screamerwebapp;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerClient customerClient;
    private List<Customer> customers;
    public CustomerService(CustomerClient customerClient) {
        this.customerClient = customerClient;
         customers = customerClient.getAllCustomer();
    }

    public List<Customer> getAllCustomers() {
        return customerClient.getAllCustomer();
    }

    public Customer getCustomerById(Long id) {
            Customer customer = new Customer();
            for(Customer cust: customers)
            {
                if(cust.getId() == id)
                {
                    customer = cust;
                    return customer;
                }
            }
        return null;
    }
}
