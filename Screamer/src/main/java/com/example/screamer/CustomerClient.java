package com.example.screamer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Anmol Saru Magar
 * File Name: CustomerClient.java
 * Date :16/9/2024
 * Purpose :
 * CustomerClient that takes request and sends that request to it assigned url
 * ******************************************************
 */
@FeignClient(name = "customer", url = "http://localhost:8009/user")
public interface CustomerClient {

    @GetMapping("/get/all")
    List<Customer> getAllCustomer();


    @GetMapping("/get/{id}")
    ResponseEntity<Customer> retrieveById(@RequestParam Long id);
    
     @GetMapping("/getByEmail/{email}")
    Customer getByEmail(@RequestParam String email);
    
    @PostMapping("/add")
    @ResponseBody
    ResponseEntity<Customer> addCustomer(@RequestBody Customer customer);

}
