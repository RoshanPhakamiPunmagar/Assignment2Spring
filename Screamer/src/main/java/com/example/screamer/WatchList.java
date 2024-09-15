package com.example.screamer;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class WatchList {
    @Id @GeneratedValue
    private long id;

    @ManyToMany
    private List<Movies> watchList = new ArrayList<>();


}
