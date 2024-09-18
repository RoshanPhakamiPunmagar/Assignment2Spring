package com.Assignment2Spring.controller;

import com.Assignment2Spring.dto.AuthRequest;
import com.Assignment2Spring.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    //this method is used to show login page.
    @GetMapping("/login")
    public String loginPage(Model model){
        AuthRequest authRequest = new AuthRequest();
        model.addAttribute("authRequest", authRequest);
        return "signin";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }
}
