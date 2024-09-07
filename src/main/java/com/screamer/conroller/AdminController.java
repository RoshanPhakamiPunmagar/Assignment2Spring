package com.screamer.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    //create method for access admin dashboard
    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "admin/dashboard";
    }
}
