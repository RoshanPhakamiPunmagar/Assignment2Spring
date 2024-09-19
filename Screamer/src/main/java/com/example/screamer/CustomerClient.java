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
    //gets list of customer
    @GetMapping("/get/all")
    List<Customer> getAllCustomer();

    //retrieves customer based on id
    @GetMapping("/get/{id}")
    ResponseEntity<Customer> retrieveById(@RequestParam Long id);
        //gets Email by Id
     @GetMapping("/getByEmail/{email}")
     Customer getByEmail(@RequestParam String email);

}
