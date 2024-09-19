package com.example.screamer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface MoviesRepository extends JpaRepository<Movies, Long> {
}
