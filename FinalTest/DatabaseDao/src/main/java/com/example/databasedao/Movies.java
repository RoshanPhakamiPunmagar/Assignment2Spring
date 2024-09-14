package com.example.databasedao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class Movies {
    @Id @GeneratedValue
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
    private boolean isWatchList;

    @ManyToMany (mappedBy = "watchList")
    private List<WatchList> onWatchList = new ArrayList<>();

    public void setIsWatchList() {
        this.isWatchList = !isWatchList;
    }
}
