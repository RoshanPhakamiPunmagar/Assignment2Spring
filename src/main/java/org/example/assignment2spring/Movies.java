package org.example.assignment2spring;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String url;

    private boolean isBlocked = false;

    @ManyToMany(mappedBy = "movies")
    private List<Customer> customers = new ArrayList<>();

    public void addUsers(Customer cust) {
        if (!this.isBlocked && !cust.isBlocked()) {
            this.customers.add(cust);
            if (!cust.getMovies().contains(this)) {
                cust.addMovie(this);
            }
        }
    }

    public void blockMovie() {
        this.isBlocked = true;
        // Optionally: Remove this movie from all customers
        for (Customer customer : new ArrayList<>(this.customers)) {
            customer.getMovies().remove(this);
        }
    }

    public void unblockMovie() {
        this.isBlocked = false;
    }
}
