package org.example.assignment2spring;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@AllArgsConstructor
@Table

public class Movies {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String url;


    private boolean isBlocked = false;

    @ManyToMany(mappedBy = "movies")

    @NonNull
    @Column(nullable = false)
    private String description;

    @NonNull
    @Column(nullable = false)
    private String subGenre;

    @NonNull
    @Column(nullable = false)
    private boolean isWatchList;

    @ManyToMany(mappedBy = "moveList")
    private List<WatchList> watchLists = new ArrayList<>();

    @ManyToMany (mappedBy = "movies")

    private List<Customer> customers = new ArrayList<>();


    public void addCustomer(Customer cust) {
        this.customers.add(cust);
        if (!cust.getMovies().contains(this)) {
            cust.addMovie(this);
        }
    }


    public void blockMovie() {

        this.isBlocked = true;
    }

    public void unblockMovie() {

        this.isBlocked = false;
    }
        
    public void addWatchList(WatchList watchList) {
        if (!watchLists.contains(watchList)) {
            watchLists.add(watchList);
            watchList.addMovie(this);
        }
    }

    public void setIsWatchList() {
        isWatchList = !isWatchList;
    }


    public boolean getWatchListStatus(){
        return this.isWatchList;

    }
}

