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

    @ManyToMany

    private List<User> users = new ArrayList<>();

    public void addUsers(User u) {
        this.users.add(u);
        if (!u.getMovies().contains(this)) {
            u.addMovies(this);
        }
    }*/
}
