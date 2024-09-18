package com.example.screamerwebapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "customer", url = "http://localhost:8003/user")
public interface CustomerClient {

    @GetMapping("/get/all")
    List<Customer> getAllCustomer();


    @GetMapping("/get/{id}")
    ResponseEntity<Customer> retrieveById(@RequestParam Long id);
    
    @GetMapping("/getByEmail/{email}")
    Customer getByEmail(@RequestParam String email);

}
