package com.screamer.security;

import com.screamer.entities.User;
import com.screamer.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //this method is used to load user by username form database and map with CustomUserDetails class.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Email id: "+username+" does not exist"));
    }
}
