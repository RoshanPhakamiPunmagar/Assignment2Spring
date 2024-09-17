package com.example.screamerwebapp;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class WatchList {
    @Id @GeneratedValue
    private long id;

    @ManyToMany
    @JoinTable(
            name = "watchlist_movies",
            joinColumns = @JoinColumn(name = "watchlist_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movies> movies = new ArrayList<>();

    @OneToOne
    @JsonBackReference
    private Customer customer;

    public void addMovie(Movies movie) {
        // Check to avoid adding duplicates
        if (!this.movies.contains(movie)) {
            this.movies.add(movie);
            movie.getWatchLists().add(this); // Maintain the bidirectional relationship
        }
    }




    @Override
    public String toString() {
        return "WatchList{" +
                "id=" + id +
                ", movieList=" + movies +
                '}';
    }

}
