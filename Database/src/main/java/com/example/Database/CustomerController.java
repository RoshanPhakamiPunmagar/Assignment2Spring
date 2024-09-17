/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Database;

import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author caleb
 */
@RestController
@Data
@Service
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getCustomer/{custID}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long custID) {
        Customer cust = customerRepository.findById(custID).get();
        return ResponseEntity.ok(cust);
    }
    
    @GetMapping("/getCustomerByEmail")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer cust = customerRepository.findByEmail(email).get();
        return ResponseEntity.ok(cust);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> cust = customerRepository.findAll();
        return ResponseEntity.ok(cust);
    }

    @DeleteMapping("/deleteCustomer/{custID}")
    public void deleteCustomer(@PathVariable long custID) {
        customerRepository.deleteById(custID);
    }

    @PutMapping("/updateCustomer/{custID}")
    public void updateCustomer(@PathVariable long custID, @RequestBody Customer cust) {

        Customer user = customerRepository.findById(custID).get();
        user = cust;
        customerRepository.save(user);

    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer cust) {
        customerRepository.save(cust);
    }

}
