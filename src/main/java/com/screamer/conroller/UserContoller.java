package com.screamer.conroller;

import com.screamer.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserContoller {

    private final UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    //this method is used to access home page of user
    @RequestMapping("/home")
    public String index(){
        return "user/index";
    }

}
