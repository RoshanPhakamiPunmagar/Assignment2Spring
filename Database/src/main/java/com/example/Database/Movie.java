/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 *
 * @author caleb
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String url;

    @NonNull
    @Column(nullable = false)
    private String description;

    @NonNull
    @Column(nullable = false)
    private String subGenre;

    @NonNull
    @Column(nullable = false)
    private boolean isWatchList;

    private boolean isBlocked = false;

    @ManyToMany
    private List<WatchList> watchLists = new ArrayList<>();

    @ManyToMany(mappedBy = "movies")
    private List<Customer> customers = new ArrayList<>();

    // Methods
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
        this.isWatchList = !this.isWatchList;
    }

    public boolean getWatchListStatus() {
        return this.isWatchList;
    }
}
