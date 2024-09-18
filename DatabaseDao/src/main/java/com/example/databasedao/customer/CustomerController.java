<<<<<<<< HEAD:DatabaseDao/src/main/java/com/example/databasedao/customer/CustomerController.java
package com.example.databasedao.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/user")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> retrieveAll() {
        List<Customer> movies = customerService.getAllCustomers();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> retrieveById(@RequestParam Long id) {
        Customer customer =  customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.postCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }
}
========
package com.example.screamerwebapp;
/*
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/user")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> retrieveAll() {
        List<Customer> movies = customerService.getAllCustomers();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> retrieveById(@RequestParam Long id) {
        Customer customer =  customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }


}*/
>>>>>>>> f1a1b85d452a349d67ec6d6127249a55b23179a4:ScreamerWebApp/src/main/java/com/example/screamerwebapp/CustomerController.java
