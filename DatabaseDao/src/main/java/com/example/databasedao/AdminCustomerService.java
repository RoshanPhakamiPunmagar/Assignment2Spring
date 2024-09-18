package com.example.databasedao;

import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCustomerService {
    private final CustomerRepository customerRepository;

    public AdminCustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public void blockCustomer(Long custId) {
        try {

            Customer customer = customerRepository.findById(custId).orElseThrow(() -> new RuntimeException("Movie not found"));
            customer.setBlocked(true);
            customerRepository.save(customer);
            System.out.println("Movie blocked");
        } catch (FeignException e) {
            // Log specific details of FeignException
            System.err.println("Feign exception while blocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to block movie", e);
        } catch (Exception e) {
            // Log general exceptions
            System.err.println("Exception while blocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to block movie", e);
        }
    }


    public void unblockCustomer(Long custId) {
        try {

            Customer customer = customerRepository.findById(custId).orElseThrow(() -> new RuntimeException("Movie not found"));
            customer.setBlocked(false);
            customerRepository.save(customer);
            System.out.println("Movie unblocked");
        } catch (FeignException e) {
            System.err.println("Feign exception while unblocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to unblock movie", e);
        } catch (Exception e) {
            System.err.println("Exception while unblocking movie: " + e.getMessage());
            throw new RuntimeException("Failed to unblock movie", e);
        }
    }

    public boolean isCustomerBlocked(Long custId) {
        try {
            Customer customer = customerRepository.findById(custId).orElseThrow(() -> new RuntimeException("Movie not found"));
            System.out.println("Movie with ID: " + custId + " is blocked: " + customer.isBlocked());
            return customer.isBlocked();
        } catch (Exception e) {
            throw new RuntimeException("Failed to check movie status", e);
        }
    }

    public List<Customer> getBlockedCustomers() {

        return customerRepository.findByBlocked(true);
    }

    public List<Customer> getUnblockedCustomers() {
        return customerRepository.findByBlocked(false);
    }

    public List<Customer> getAllCustomers() {
        return  customerRepository.findAll();
    }
}
