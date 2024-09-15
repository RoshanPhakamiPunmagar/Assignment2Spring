package com.Assignment2Spring.controller;

import com.Assignment2Spring.dto.AuthRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {

    //this method is used to show login page.
    @GetMapping("/login")
    public String loginPage(Model model){
        AuthRequest authRequest = new AuthRequest();
        model.addAttribute("authRequest", authRequest);
        return new String("signin");
    }

}
