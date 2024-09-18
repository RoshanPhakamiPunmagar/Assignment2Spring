package com.Assignment2Spring.controller;

import com.Assignment2Spring.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //this is test method for check login.
    @GetMapping
    public String message(){
        return "Login successfully.";
    }



}
