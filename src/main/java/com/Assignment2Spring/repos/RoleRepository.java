package com.Assignment2Spring.repos;

import com.Assignment2Spring.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    //this method is used to get role by name.
    Optional<Role> findByName(String name);

}
