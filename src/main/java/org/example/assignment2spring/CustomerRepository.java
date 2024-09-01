package org.example.assignment2spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Find all non-blocked users
    List<Customer> findByIsBlockedFalse();

}