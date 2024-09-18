package com.example.databasedao.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WatchListRepository extends JpaRepository<WatchList, Long> {
}
