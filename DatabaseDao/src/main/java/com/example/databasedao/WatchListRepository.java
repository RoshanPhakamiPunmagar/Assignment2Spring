package com.example.databasedao;

import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Anmol Saru Magar
 * File Name: WatchListRepository.java
 * Date :16/9/2024
 * Purpose :
 * WatchList Class to save the watchlist data
 * ******************************************************
 */
@RepositoryRestResource
interface WatchListRepository extends JpaRepository<WatchList, Long> {
    //Returns Watchlist based upon user id in watchlist
    @Query("SELECT wl FROM WatchList wl WHERE wl.customer.id = :id")
   WatchList findByCustomerId(@Param("id") Long id);
}
