<<<<<<<< HEAD:DatabaseDao/src/main/java/com/example/databasedao/customer/CustomerService.java

package com.example.databasedao.customer;



import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer postCustomer(Customer customer) {
        System.out.println(customer.getId());
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findByBlocked(false);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
========
package com.example.databasedao;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer postCustomer(Customer customer) {
        System.out.println(customer.getId());
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findByBlocked(false);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
>>>>>>>> f1a1b85d452a349d67ec6d6127249a55b23179a4:DatabaseDao/src/main/java/com/example/databasedao/CustomerService.java
