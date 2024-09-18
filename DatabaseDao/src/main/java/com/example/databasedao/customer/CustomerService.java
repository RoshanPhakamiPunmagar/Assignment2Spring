<<<<<<< Updated upstream:DatabaseDao/src/main/java/com/example/databasedao/CustomerService.java
package com.example.databasedao;
=======
package com.example.databasedao.customer;
>>>>>>> Stashed changes:DatabaseDao/src/main/java/com/example/databasedao/customer/CustomerService.java


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
