package com.example.screamer;


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {


    private final MovieClient movieClient;
    private List<Movies> movies;

    public MovieService(MovieClient movieClient) {
        this.movieClient = movieClient;

    }


    public List<Movies> getAllMovies() {
        try {
            movies = movieClient.getAllMovies();
            return movies;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

    public WatchList getAllWatchListMovies() {
        try {
            System.out.println(getAllMovies().get(0).getIsWatchList());
            WatchList watchLists = movieClient.getAllWatchList();
            //  watchListRepository.save(watchLists);
            return watchLists;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

    public WatchList removeFromWatchList(Long id) {

        return  movieClient.addMoveToWatchList(id, "Remove");

    }

    public WatchList addToWatchList(Long id) {

        return movieClient.addMoveToWatchList(id, "Add");
    }
}
