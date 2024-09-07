package com.screamer.conroller;

import com.screamer.entities.User;
import com.screamer.services.UserService;
import com.screamer.utils.helper.Message;
import com.screamer.utils.helper.MessageType;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageConroller {

    private final UserService userService;

    public PageConroller(UserService userService) {
        this.userService = userService;
    }

    //this method used for access login page
    @RequestMapping("/login")
    public String loginPage(){
        return new String("login");
    }


    //this method used for show register page
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return new String("register");
    }

    //this method is used to register new user.
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, HttpSession session){
        userService.addUser(user);
        Message msg = Message.builder().content("User Registered Successfully").type(MessageType.success).build();
        session.setAttribute("message", msg);
        return "register";
    }

}
