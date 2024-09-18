package com.example.databasedao.admin;

import com.example.databasedao.customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/admin/customer")
public class AdminCustomerController {

    private final AdminCustomerService adminCustomerService;

    public AdminCustomerController(AdminCustomerService adminCustomerService) {
        this.adminCustomerService = adminCustomerService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> listCustomers() {
        List<Customer> customer = adminCustomerService.getAllCustomers();
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/blocked")
    public ResponseEntity<List<Customer>> listBlockedCustomers() {
        List<Customer> customerList = adminCustomerService.getBlockedCustomers();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/unblocked")
    public ResponseEntity<List<Customer>> listUnblockedCustomers() {
        List<Customer> unBlockedCustomer = adminCustomerService.getUnblockedCustomers();
        return ResponseEntity.ok(unBlockedCustomer);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<Boolean> checkCustomerStatus(@PathVariable Long id) {
        boolean isBlocked = adminCustomerService.isCustomerBlocked(id);
        return ResponseEntity.ok(isBlocked);
    }

    @PostMapping("/block/{id}")
    public ResponseEntity<Void> blockCustomers(@PathVariable Long id) {
        adminCustomerService.blockCustomer(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @PostMapping("/unblock/{id}")
    public ResponseEntity<Void> unblockCustomers(@PathVariable Long id) {
        adminCustomerService.unblockCustomer(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
