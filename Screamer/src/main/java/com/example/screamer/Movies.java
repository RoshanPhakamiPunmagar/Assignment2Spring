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

    @Setter
    @NonNull
    private boolean isWatchList;


    @ManyToMany (mappedBy = "movies")
    private List<WatchList> watchLists = new ArrayList<>();

    public boolean getIsWatchList() {
        return this.isWatchList;
    }

}
