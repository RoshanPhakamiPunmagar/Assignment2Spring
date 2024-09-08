package org.example.assignment2spring;

import java.util.List;

public interface CustomerService {

    // Returns a list of all non-blocked users
    List<Customer> findAllUsers();

    // Get user by their ID
    Customer getUserById(Long id);

    // Block a user by ID
    void blockUser(Long id);

    // Unblock a user by ID
    void unblockUser(Long id);

}