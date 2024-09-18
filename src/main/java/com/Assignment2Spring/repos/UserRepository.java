package com.Assignment2Spring.repos;

import com.Assignment2Spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    //this method is used to get user by email.
    Optional<User> findByEmail(String email);

}
