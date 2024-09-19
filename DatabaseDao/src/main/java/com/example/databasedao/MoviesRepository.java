package com.example.databasedao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
/**
 *
 * @author Anmol Saru Magar
 * File Name: MoviesRepository.java
 * Date :16/9/2024
 * Purpose :
 * MoviesRepository gets that stores the client data and returns the data according to the requests made
 *
 */
@RepositoryRestResource
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    //Returns movie based on blocked status
    List<Movies> findByBlocked(boolean blocked);
}
