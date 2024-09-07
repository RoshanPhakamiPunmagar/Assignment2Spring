package com.screamer.repos;

import com.screamer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    //find user by email from database using jpa
    Optional<User> findByEmail(String email);
}
