package com.example.Database;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface MoviesRepository extends JpaRepository<Movies, Long> {

    Movies saveMovies(Movies movies);

    public List<Movies> getAllMovies();

    public List<WatchList> getAllWatchListMovies();

    public Optional<Movies> fetchMovieById(Long id);

    public WatchList addOrRemoveFromWatchList(Long id);

    //removes the movie from watchlist
    public WatchList removeFromWatchList(Long id);

    public Optional<Movies> updateProduct(Long id, Movies updatedProduct);

    public boolean deleteMovie(Long id);

}
