package com.Assignment2Spring.controller;

import com.Assignment2Spring.dto.AuthRequest;
import com.Assignment2Spring.dto.AuthResponse;
import com.Assignment2Spring.security.CustomUserDetailsService;
import com.Assignment2Spring.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthController(CustomUserDetailsService userDetailsService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    //This method is used to generate token using email and password
    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@ModelAttribute AuthRequest authRequest){
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        Authentication authentication;
        try{
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (Exception e){
            throw new RuntimeException("Invalid Credentials");
        }
        if(authentication.isAuthenticated()){
            String token = jwtService.generateToken(authRequest.getUsername());
            return  new ResponseEntity<Object>(new AuthResponse(token), HttpStatus.OK);
        }
        throw new RuntimeException("Something went wrong.");
    }

}
