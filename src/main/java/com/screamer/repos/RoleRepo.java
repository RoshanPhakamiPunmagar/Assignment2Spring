package com.screamer.repos;

import com.screamer.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    //this method is used to find role by name
    Optional<Role> findByName(String name);
}
