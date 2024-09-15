package com.Assignment2Spring.security;

import com.Assignment2Spring.entities.User;
import com.Assignment2Spring.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//This class is used by spring security for get get user from database using username.
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        //map user to CustomeUserDetails class.
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User does not exist with email: "+username));
    }
}
