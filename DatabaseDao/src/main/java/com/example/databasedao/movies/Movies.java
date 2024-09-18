package com.example.databasedao.movies;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing the Movies.
 * This class defines the properties of a movie and its relationship with watch lists.
 * It is annotated with JPA annotations to facilitate ORM with the database.
 *
 * @author Anmol Saru Magar
 * Date: 16/9/2024
 */
@Entity
@Data
@NoArgsConstructor
public class Movies {
    @Id
    @GeneratedValue
    private Long id; // Unique identifier for each movie

    @NonNull
    private String title; // Title of the movie

    @NonNull
    private String url; // URL for the movie (e.g., YouTube link)

    @NonNull
    private String description; // Description of the movie

    @NonNull
    private String subGenre; // Sub-genre of the movie (e.g., Horror, Comedy)

    @NonNull
    private boolean inWatchList; // Indicates if the movie is in the user's watch list

    @NonNull
    private boolean blocked; // Indicates if the movie is blocked

    // Many-to-many relationship with WatchList, where the Movies are the inverse side
    @ManyToMany(mappedBy = "movies")
    @JsonBackReference // Prevents infinite recursion during JSON serialization
    private List<WatchList> watchLists = new ArrayList<>(); // List of watch lists containing this movie

    // Getter for inWatchList
    public boolean getInWatchList() {
        return this.inWatchList;
    }

    // Setter for inWatchList
    public void setInWatchList(boolean inWatchList) {
        this.inWatchList = inWatchList;
    }

    // Custom toString method for easier debugging and logging
    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", subGenre='" + subGenre + '\'' +
                ", inWatchList=" + this.inWatchList +
                '}';
    }
}
