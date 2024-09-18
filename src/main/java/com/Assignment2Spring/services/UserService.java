package com.Assignment2Spring.services;

import com.Assignment2Spring.entities.Role;
import com.Assignment2Spring.entities.User;
import com.Assignment2Spring.repos.RoleRepository;
import com.Assignment2Spring.repos.UserRepository;
import com.Assignment2Spring.utils.AppConstants;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    //This method is used to add user in database with user role.
    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName(AppConstants.USER_ROLE).orElseThrow(() -> new RuntimeException("Role not found with role name: "+AppConstants.USER_ROLE));
        user.setRoles(Set.of(role));
        userRepository.save(user);
    }
}
