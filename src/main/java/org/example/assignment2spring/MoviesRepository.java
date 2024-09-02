package org.example.assignment2spring;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
    // Custom query method to find non-blocked movies
    List<Movies> findByIsBlockedFalse();
}
