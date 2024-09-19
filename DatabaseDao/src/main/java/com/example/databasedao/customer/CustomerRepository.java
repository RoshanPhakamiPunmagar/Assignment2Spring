package com.example.databasedao.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
/**
 * Repository interface for managing Customer entities.
 *
 * @author: Anmol Saru Magar
 */
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    // Find customers based on their blocked status
    List<Customer> findByBlocked(boolean blocked);
}
