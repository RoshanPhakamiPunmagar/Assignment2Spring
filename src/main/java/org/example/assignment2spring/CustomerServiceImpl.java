package org.example.assignment2spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    // Fetch all users (both blocked and non-blocked)
    public List<Customer> findAllUsers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getUserById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void blockUser(Long id) {
        Customer user = getUserById(id);
        user.blockUser();
        customerRepository.save(user);
    }

    @Override
    public void unblockUser(Long id) {
        Customer user = getUserById(id);
        user.unblockUser();
        customerRepository.save(user);
    }
}
