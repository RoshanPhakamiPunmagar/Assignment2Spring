package com.example.databasedao.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Repository interface for managing Movies entities.
 *
 * @author: Anmol Saru Magar
 */
@RepositoryRestResource // Exposes the repository as a REST resource
public interface MoviesRepository extends JpaRepository<Movies, Long> {

    /**
     * Retrieves a list of Movies based on their blocked status.
     */
    List<Movies> findByBlocked(boolean blocked); // Custom query method to find movies by their blocked status
}
