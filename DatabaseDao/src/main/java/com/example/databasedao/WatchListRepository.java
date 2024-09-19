package com.example.databasedao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/**
 * Repository interface for managing Watchlist entities.
 *
 * @author: Anmol Saru Magar
 */
@RepositoryRestResource

public interface WatchListRepository extends JpaRepository<WatchList, Long> {
}
