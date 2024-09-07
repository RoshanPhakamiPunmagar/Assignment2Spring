package org.example.assignment2spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class WatchList {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    private List<Movies> moveList = new ArrayList<>();

    public void addMovie(Movies movie) {
        if (!this.moveList.contains(movie)) {
            this.moveList.add(movie);
        }
    }
}

