package com.example.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/admin/customer")
public class AdminCustomerController {

        private final AdminCustomerService adminCustomerService;

        public AdminCustomerController(AdminCustomerService adminCustomerService) {
            this.adminCustomerService = adminCustomerService;
        }

        @GetMapping("/get/all")
        public ResponseEntity<List<Customer>> listCustomers() {
            List<Customer> customers = adminCustomerService.getAllCustomers();
            return ResponseEntity.ok(customers);
        }

        @GetMapping("/blocked")
        public ResponseEntity<List<Customer>> listBlockedCustomers() {
            List<Customer> blockedCustomers = adminCustomerService.getBlockedCustomers();
            return ResponseEntity.ok(blockedCustomers);
        }

        @GetMapping("/unblocked")
        public ResponseEntity<List<Customer>> listUnblockedCustomers() {
            List<Customer> unblockedCustomers = adminCustomerService.getUnblockedCustomers();
            return ResponseEntity.ok(unblockedCustomers);
        }

        @GetMapping("/status/{id}")
        public ResponseEntity<Boolean> checkCustomerStatus(@PathVariable Long id) {
            boolean isBlocked = adminCustomerService.isCustomerBlocked(id);
            return ResponseEntity.ok(isBlocked);
        }

        @PostMapping("/block/{id}")
        public ResponseEntity<Void> blockCustomer(@PathVariable Long id) {
            adminCustomerService.blockCustomer(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        @PostMapping("/unblock/{id}")
        public ResponseEntity<Void> unblockCustomer(@PathVariable Long id) {
            adminCustomerService.unblockCustomer(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }


}
