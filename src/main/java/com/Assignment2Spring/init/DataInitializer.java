package com.Assignment2Spring.init;

import com.Assignment2Spring.entities.Role;
import com.Assignment2Spring.entities.User;
import com.Assignment2Spring.repos.RoleRepository;
import com.Assignment2Spring.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

//This class is used to create default role and customer when project start.
@Component
@Slf4j
public class DataInitializer implements ApplicationRunner {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Added role in database if role dosen't exists
        if (!roleRepository.findByName("ROLE_ADMIN").isPresent()) {
            // Insert the role if it does not exist
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            roleRepository.save(role);
            log.info("[DataInitializer][run] Inserted role: ROLE_ADMIN");
        }

        if (!roleRepository.findByName("ROLE_USER").isPresent()) {
            // Insert the role if it does not exist
            Role role = new Role();
            role.setName("ROLE_USER");
            roleRepository.save(role);
            log.info("[DataInitializer][run] Inserted role: ROLE_USER");
        }

        //Added user in database if user dosen't exists
        if(!userRepository.findByEmail("admin@admin.com").isPresent()){
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@admin.com");
            user.setPassword(passwordEncoder.encode("admin@123"));

            Role role = roleRepository.findByName("ROLE_ADMIN").orElse(null);
            user.setRoles(Set.of(role));
            userRepository.save(user);
        }

        if(!userRepository.findByEmail("user@user.com").isPresent()){
            User user = new User();
            user.setName("User");
            user.setEmail("user@user.com");
            user.setPassword(passwordEncoder.encode("user@123"));

            Role role = roleRepository.findByName("ROLE_USER").orElse(null);
            user.setRoles(Set.of(role));
            userRepository.save(user);
        }
    }
}
