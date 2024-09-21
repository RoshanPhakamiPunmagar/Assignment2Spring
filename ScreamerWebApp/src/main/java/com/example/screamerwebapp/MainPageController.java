/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.screamerwebapp;

import lombok.Data;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author caleb
 */
@Controller
@Data
@RequestMapping()
public class MainPageController {
 @Autowired
    private final CustomerClient customerClient;

  

    @GetMapping("/register")
    public String register(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
                    System.out.println("Debug: " + "User is logged in");
                    return "/view/landing";
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
        customer.setWatchList(new WatchList());

        System.out.println("Debug: " + customer);
        customerClient.addCustomer(customer);
        return "login";
    }

    @GetMapping("/login")
    public String login() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            System.out.println("Debug: " + "User is logged in");
            //  return "landing";

            return "redirect:/landing";

        }

        return "login";
    }

    @GetMapping("/landing")
    public String landing() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            System.out.println("Debug: " + "User is logged in");
            return "landing";
        }

        return "redirect:/login";
    }
}
