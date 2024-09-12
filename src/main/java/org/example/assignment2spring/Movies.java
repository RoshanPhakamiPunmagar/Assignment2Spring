package org.example.assignment2spring;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
public class Movies {

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
    private boolean isWatchList;

    private boolean isBlocked = false;

    // Many-to-Many with WatchList
    @ManyToMany(mappedBy = "movies")  // Ensure 'movies' field exists in WatchList
    private List<WatchList> watchLists = new ArrayList<>();

    // Many-to-Many with User
    @ManyToMany(mappedBy = "movies")
    private List<User> customers = new ArrayList<>();

    public void addUser(User user) {
        this.customers.add(user);
        if (!user.getMovies().contains(this)) {
            user.addMovie(this);
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
