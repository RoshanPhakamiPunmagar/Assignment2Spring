package org.example.assignment2spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllUsers() {
        // Returns all users that are not blocked
        return customerRepository.findByIsBlockedFalse();
    }

    @Override
    public Customer getUserById(Long id) {
        // Get the user by ID or throw an exception if not found
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void blockUser(Long id) {
        // Block the user and save the state
        Customer user = getUserById(id);
        user.blockUser();
        customerRepository.save(user);
    }

    @Override
    public void unblockUser(Long id) {
        // Unblock the user and save the state
        Customer user = getUserById(id);
        user.unblockUser();
        customerRepository.save(user);
    }

    @Override
    public void saveUser(Customer user) {
        // Save or update user
        customerRepository.save(user);
    }
}
