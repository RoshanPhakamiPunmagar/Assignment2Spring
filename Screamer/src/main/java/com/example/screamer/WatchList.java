package com.example.screamer;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @Override
    public String toString() {
        return "WatchList{" +
                "id=" + id +
                ", movieList=" + movies +
                '}';
    }

}
