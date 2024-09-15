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

    
     @GetMapping("/getCustomer/{custId}")
    public  ResponseEntity<Customer> getUser(@PathVariable long custId) {
         Customer cust =  customerRepository.findById(custId).get();
         return ResponseEntity.ok(cust);
    }
    @GetMapping("/getCustomers/")
    public  ResponseEntity<List<Customer>> getUser() {
         List<Customer> cust =  customerRepository.findAll();
         return ResponseEntity.ok(cust);
    }
    @DeleteMapping("/deleteUser/{custId}")
    public void deleteUser(@PathVariable long custId)
    {
        customerRepository.deleteById(custId);
    }
    

}
