package com.example.screamer;

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

    @ManyToMany (mappedBy = "watchList")
    private List<WatchList> onWatchList = new ArrayList<>();

    public boolean getIsWatchList() {
        return isWatchList;
    }

}
