package com.example.admin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCustomerService {

    private final AdminCustomerClient adminClient;

    public AdminCustomerService(AdminCustomerClient adminClient) {
        this.adminClient = adminClient;
    }

    public void blockCustomer(Long customerId) {
        adminClient.blockCustomers(customerId);
    }

    public void unblockCustomer(Long customerId) {
        adminClient.unblockCustomers(customerId);
    }

    public boolean isCustomerBlocked(Long customerId) {
        return adminClient.checkCustomerStatus(customerId);
    }

    public List<Customer> getBlockedCustomers() {
        return adminClient.listBlockedCustomers();
    }

    public List<Customer> getUnblockedCustomers() {
        return adminClient.listUnblockedCustomers();
    }

    public List<Customer> getAllCustomers() {
        return adminClient.listCustomers();
    }
}