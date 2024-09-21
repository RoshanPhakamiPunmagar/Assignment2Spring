package com.example.screamerwebapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Anmol Saru Magar
 * File Name: CustomerClient.java
 * Date :16/9/2024
 * Purpose :
 * CustomerClient that takes request and sends that request to it assigned url
 * ******************************************************
 */
@FeignClient(name = "screamerService", url = "http://localhost:8003/user")
public interface CustomerClient {

    @GetMapping("/get/all")
    List<Customer> getAllCustomer();

    @GetMapping("/get/{id}")
    ResponseEntity<Customer> retrieveById(@RequestParam Long id);
    
    @GetMapping("/getByEmail/{email}")
    Customer getByEmail(@RequestParam String email);
    
    @PostMapping("/addCustomer")
    @ResponseBody
    ResponseEntity<Void> addCustomer(@RequestBody Customer customer);

}
