package com.example.screamer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @NoArgsConstructor @RequiredArgsConstructor
public class Movies {
    @Id @GeneratedValue
    private long id;

    @NonNull
    private String title;

    @NonNull
    private String url;

    @NonNull
    private String description;

    @NonNull
    private String subGenre;


    @NonNull
    private boolean isWatchList;


    @ManyToMany (fetch = FetchType.EAGER, mappedBy = "movies")
    private List<WatchList> watchLists = new ArrayList<>();

    public void addWatchlist(WatchList watchList) {
        // Check to avoid adding duplicates
        if (!this.watchLists.contains(watchList)) {
            this.watchLists.add(watchList);
            watchList.getMovies().add(this); // Maintain the bidirectional relationship
        }
    }

    public boolean getIsWatchList() {
        return this.isWatchList;
    }

}
