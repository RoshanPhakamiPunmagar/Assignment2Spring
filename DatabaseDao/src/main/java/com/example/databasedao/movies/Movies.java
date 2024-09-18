package com.example.databasedao.movies;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Movies.java
 * @author : Anmol Saru Magar
 * Date: 16/09/2024
 * Purpose:
 * This entity class represents a movie. It contains the properties of a movie
 * and manages its relationship with the WatchList entity through a many-to-many mapping.
 */
@Entity
@Data
@NoArgsConstructor
public class Movies {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String url;

    @NonNull
    private String description;

    @NonNull
    private String subGenre;

    @NonNull
    private boolean inWatchList;

    @NonNull
    private boolean blocked;

    // Many-to-many relationship between Movies and WatchList
    @ManyToMany(mappedBy = "movies")
    @JsonBackReference // Prevents circular reference during serialization to JSON
    private List<WatchList> watchLists = new ArrayList<>();

    /**
     * Getter method for the 'inWatchList' field.
     * @return boolean indicating if the movie is in the watch list
     */
    public boolean getInWatchList() {
        return this.inWatchList;
    }

    /**
     * Setter method for the 'inWatchList' field.
     * @param inWatchList boolean flag to set the watch list status
     */
    public void setInWatchList(boolean inWatchList) {
        this.inWatchList = inWatchList;
    }

    /**
     * Custom toString method for easier debugging and logging.
     * @return String representation of the movie object
     */
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
