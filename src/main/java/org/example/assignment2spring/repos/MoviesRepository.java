package org.example.assignment2spring.repos;

import org.example.assignment2spring.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoviesRepository extends JpaRepository<Movies, Long> {
}
