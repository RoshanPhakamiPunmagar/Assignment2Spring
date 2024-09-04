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
@AllArgsConstructor @Table
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull    @Column(nullable = false)
    private String title;

    @NonNull  @Column(nullable = false)
    private String url;

    @NonNull  @Column(nullable = false)
    private String description;

    @ManyToMany (mappedBy = "movies")
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer cust) {
        this.customers.add(cust);
        if (!cust.getMovies().contains(this)) {
            cust.addMovie(this);
        }
    }
}
