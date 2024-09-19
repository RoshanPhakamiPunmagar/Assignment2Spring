package com.example.databasedao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
/**
 *
 * @author Roshan Phakami Pun Magar & Anmol Saru Magar
 * File Name: CustomerRepository.java
 * Date :16/9/2024
 * Purpose :
 * CustomerRepository that return the customer data
 * Some of the return data are defined
 * ******************************************************
 */
@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer,Long> {
    //return customer based on blocked status
    List<Customer> findByBlocked(boolean blocked);
    //return customer based on email
    Customer findByEmail(String email);
}
