package org.example.assignment2spring;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@RequiredArgsConstructor @Table
public class Customer {
    @Id
    @GeneratedValue private Long id;
    @NonNull   @Column(nullable = false) private String name;

    @ManyToMany
    private List<Movies> movies = new ArrayList<>();

    public void addMovie(Movies movie) {
        this.movies.add(movie);
        if(!this.movies.contains(movie)){
            movie.addCustomer(this);
        }
    }

}
