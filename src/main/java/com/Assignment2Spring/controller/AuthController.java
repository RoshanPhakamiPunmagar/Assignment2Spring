package com.Assignment2Spring.controller;

import com.Assignment2Spring.dto.AuthRequest;
import com.Assignment2Spring.dto.AuthResponse;
import com.Assignment2Spring.entities.User;
import com.Assignment2Spring.security.CustomUserDetailsService;
import com.Assignment2Spring.security.JwtService;
import com.Assignment2Spring.services.UserService;
import com.Assignment2Spring.utils.helper.Message;
import com.Assignment2Spring.utils.helper.MessageType;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserService userService;

    public AuthController(CustomUserDetailsService userDetailsService, AuthenticationManager authenticationManager, JwtService jwtService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    //This method is used to generate token using email and password
    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@ModelAttribute AuthRequest authRequest, HttpSession httpSession){
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        Authentication authentication;
        try{
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (Exception e){
            Message msg = Message.builder().content("Invalid Credentials").type(MessageType.danger).build();
            httpSession.setAttribute("message", msg);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/login")
                    .build();
        }
        if(authentication.isAuthenticated()){
            String token = jwtService.generateToken(userDetails);
            return  new ResponseEntity<Object>(new AuthResponse(token), HttpStatus.OK);
        }
        throw new RuntimeException("Something went wrong.");
    }

    //this method is used to register user.
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, HttpSession session){
        userService.addUser(user);
        Message msg = Message.builder().content("User Registered Successfully").type(MessageType.success).build();
        session.setAttribute("message", msg);
        return "signup";
    }

}
