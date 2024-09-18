package com.example.admin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "admin-customer", url = "http://localhost:8009/admin/customer")
public interface AdminCustomerClient {
    @GetMapping("/get/all")
    List<Customer> listCustomers();

    @GetMapping("/blocked")
    List<Customer> listBlockedCustomers();

    @GetMapping("/unblocked")
    List<Customer> listUnblockedCustomers();

    @GetMapping("/status/{id}")
    Boolean checkCustomerStatus(@PathVariable Long id);

    @PostMapping("/block/{id}")
    ResponseEntity<Void> blockCustomers(@PathVariable Long id);

    @PostMapping("/unblock/{id}")
    ResponseEntity<Void> unblockCustomers(@PathVariable Long id);
}
