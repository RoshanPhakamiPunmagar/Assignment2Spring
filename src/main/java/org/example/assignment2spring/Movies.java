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
public class Movies {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String url;

    private boolean isBlocked = false;

    @ManyToMany(mappedBy = "movies")
    private List<Customer> customers = new ArrayList<>();

    public void addUsers(Customer cust) {
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
}
