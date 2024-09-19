

package com.example.databasedao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
/**
 * Customer.java
 * @author : Anmol Saru Magar
 * Date: 16/09/2024
 * Purpose:
 * This entity class represents a Customer. It contains the properties of a Customer
 * and manages its relationship with the WatchList entity through a one-to-one mapping.
 */
@Entity @Data @NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String password;

    @NonNull
    private boolean blocked;

    @OneToOne (mappedBy = "customer")
    @JsonBackReference
    private WatchList watchList;

}

