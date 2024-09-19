package com.example.databasedao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByBlocked(boolean blocked);
    Customer findByemail(String email);
}