package com.example.databasedao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

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
    private boolean inWatchList; // Renamed for clarity

    @NonNull
    private boolean blocked;

    @ManyToMany(mappedBy = "movies")
    @JsonBackReference
    private List<WatchList> watchLists = new ArrayList<>();


    // Optionally, add a toggle method
    public boolean getInWatchList() {
        return this.inWatchList;
    }

    public void setInWatchList(boolean inWatchList) {
        this.inWatchList = inWatchList;
    }

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
