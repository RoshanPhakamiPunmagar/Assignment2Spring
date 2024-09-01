package org.example.assignment2spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private boolean isBlocked = false;

    @ManyToMany
    private List<Movies> movies = new ArrayList<>();

    public void addMovie(Movies movie) {
        if (!this.isBlocked && !movie.isBlocked() && !this.movies.contains(movie)) {
            this.movies.add(movie);
            movie.addUsers(this);
        }
    }

    public void blockUser() {
        this.isBlocked = true;
    }

    public void unblockUser() {
        this.isBlocked = false;
    }
}
