package com.screamer.services;

import com.screamer.entities.Role;
import com.screamer.entities.User;
import com.screamer.repos.RoleRepo;
import com.screamer.repos.UserRepo;
import com.screamer.utils.AppConstant;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

//this service is used to handle user related operation
@Service
public class UserService {
    
    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public User addUser(User user){
        Role role = roleRepo.findByName(AppConstant.USER_ROLE).orElseThrow(() -> new UsernameNotFoundException("Role not found with name: "+AppConstant.USER_ROLE));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(role));
        return userRepo.save(user);
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User getUserById(Integer userId){
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public void deleteUserById(Integer userId){
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
    }

    public boolean isUserExistsByEmail(String email){
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null;
    }
}
