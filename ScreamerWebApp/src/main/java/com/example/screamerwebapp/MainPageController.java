/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.screamerwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author caleb
 */
@Controller
@RequestMapping()
public class MainPageController {

    private final AdminCustomerClient adminCustomerClient;

    public MainPageController(AdminCustomerClient adminCustomerClient) {
        this.adminCustomerClient = adminCustomerClient;
    }


    @GetMapping("/register")
    public String register(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
                    System.out.println("Debug: " + "User is logged in");
                    return "landing";
        }
        		model.addAttribute("customer", new Customer());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerNew(@ModelAttribute Customer customer) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
                    System.out.println("Debug: " + "User is logged in");
                    return "landing";
        }
        	customer.setRoll("ROLE_USER");
                adminCustomerClient.addCustomer(customer);
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
                    System.out.println("Debug: " + "User is logged in");
                    return "landing";
        }
        
        return "login";
    }
}
