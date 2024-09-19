package com.example.databasedao;

import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface WatchListRepository extends JpaRepository<WatchList, Long> {
    @Query("SELECT wl FROM WatchList wl WHERE wl.customer.id = :id")
   WatchList findByCustomerId(@Param("id") Long id);
}
