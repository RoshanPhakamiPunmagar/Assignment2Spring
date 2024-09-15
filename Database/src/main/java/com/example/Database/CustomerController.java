/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author caleb
 */
@RestController @RequestMapping
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    
     @GetMapping("/getUser/{custID}")
    public  ResponseEntity<Customer> getUser(@PathVariable long custId) {
         Customer cust =  customerRepository.findById(custId).get();
         return ResponseEntity.ok(cust);
    }

}
