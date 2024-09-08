package org.example.assignment2spring;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
    List<Movies> findByIsBlockedFalse();
}
