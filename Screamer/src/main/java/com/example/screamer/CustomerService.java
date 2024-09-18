package com.example.screamer;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerClient customerClient;
    private List<Customer> customers;
    public CustomerService(CustomerRepository customerRepository, CustomerClient customerClient) {
        this.customerRepository = customerRepository;
        this.customerClient = customerClient;
         customers = customerClient.getAllCustomer();
    }

    public Customer postCustomer(Customer customer) {
        System.out.println(customer.getId());
        return customerRepository.save(customer);
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
    
    public Customer getByEmail(String email)
    {
        return customerClient.getByEmail(email);
    }
}
