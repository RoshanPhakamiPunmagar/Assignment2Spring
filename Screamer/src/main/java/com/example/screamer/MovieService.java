package com.example.screamer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MoviesRepository movieRepository;

    private final MovieClient movieClient;

    private final WatchListRepository watchListRepository;

    private WatchList savedWatchList = new WatchList();

    public MovieService(MoviesRepository moviesRepository, MovieClient movieClient, WatchListRepository watchListRepository) {
        this.movieRepository = moviesRepository;
        this.movieClient = movieClient;
        this.watchListRepository = watchListRepository;

    }
    @Transactional
    public List<Movies> getAllMovies () {
        try {
            List<Movies> movies = movieClient.getAllMovies();
            movieRepository.saveAll(movies);
            System.out.println(movies.get(0).getIsWatchList() + "x");

            return movies;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

    public Movies updateMovie(Long id, Movies x) {
        System.out.println("124124");
        System.out.println(id);
        List<Movies> movies = getAllMovies();
        System.out.println(id);
        Movies existingMovie = new Movies();
        System.out.println(id);
        for (Movies m : movies) {
            if (m.getId() == id) {
                existingMovie = m;
                break;
            }
        }

        System.out.println(existingMovie.getId());
        // Update the fields as needed
        existingMovie.setWatchList(!x.getIsWatchList());
        existingMovie.setTitle("qweqweqwe");

        movieClient.updateMovieById(id, existingMovie);
        // Save the updated movie
        return movieRepository.save(existingMovie);
    }
    public WatchList getAllWatchListMovies() {
        try {
            System.out.println(getAllMovies().get(0).getIsWatchList());
            WatchList watchLists = movieClient.getAllWatchList();
            watchListRepository.save(watchLists);
            return watchLists;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

    public WatchList removeFromWatchList(Long id){
        List<Movies> movies =  getAllMovies();

     WatchList watchList = getAllWatchListMovies();

        List<Movies> moviesToAdd= watchList.getMovies();
        Movies movieToRemove = new Movies();
        for (Movies m : movies) {
            if (m.getId() == (id)) {
                m.setWatchList(false);
                movieToRemove = m;
                break;
            }
        }
        System.out.println(movieToRemove.getIsWatchList());


            // Remove the movie from the list
            movies.remove(movieToRemove);
            watchList.setMovies(movies);
        movieRepository.save(movieToRemove);
            // Save the updated watchlist
                movieClient.addWatchList(id, "Remove");

        savedWatchList = watchListRepository.save(watchList);
        return savedWatchList;

    }

    @Transactional
    public WatchList addToWatchList(Long id) {
        List<Movies> movies =  getAllMovies();
   Movies movieToAdd = new Movies();
        for (Movies m : movies) {
            if (m.getId() == id) {
                System.out.println(m.getIsWatchList());
                m.setWatchList(true);
                movieToAdd = m;
            }
        }
        //Saving to repository

        System.out.println(movieToAdd.getIsWatchList());
        List<Movies> moviesToAdd= new ArrayList<>();

        moviesToAdd.add(movieToAdd);
        movieToAdd.setWatchList(movieToAdd.getIsWatchList());

        WatchList watchList = new WatchList();
        watchList.setMovies(moviesToAdd);

        movieRepository.save(movieToAdd);

        movieClient.addWatchList(id, "Add");
        savedWatchList = watchListRepository.save(watchList);
        return savedWatchList;
    }
}

