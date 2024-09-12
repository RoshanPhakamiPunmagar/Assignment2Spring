package org.example.assignment2spring;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
public class Assignment2SpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(Assignment2SpringApplication.class, args);
    }

}

@Component
@Data
@Transactional
class AppInit implements ApplicationRunner {
    private final MovieController movieController;
    private final MoviesRepository moviesRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create and save movies
        Movies m = new Movies();
        m.setTitle("Herop");
        m.setUrl("https://www.youtube.com/watch?v=cE7vGF60cRA&pp=ygUNd3Vrb25nIHJldmlldw%3D%3D");
        moviesRepository.save(m); // Save and automatically generate ID
        movieController._update(m.getId(), m); // Use the generated ID for updating

        Movies m1 = new Movies();
        m1.setTitle("Say It");
        m1.setUrl("https://www.youtube.com/watch?v=F64yFFnZfkI");
        moviesRepository.save(m1); // Save and automatically generate ID
        movieController._update(m1.getId(), m1); // Use the generated ID for updating

        // Create and save users
        Customer user1 = new Customer();
        user1.setName("John Doe");
        user1.setBlocked(false);
        customerRepository.save(user1);

        Customer user2 = new Customer();
        user2.setName("Jane Smith");
        user2.setBlocked(false);
        customerRepository.save(user2);

        Customer user3 = new Customer();
        user3.setName("Bob Brown");
        user3.setBlocked(false);
        customerRepository.save(user3);

        // Print the created entities
        System.out.println("Movies created: " + moviesRepository.findAll());
        System.out.println("Users created: " + customerRepository.findAll());
    }
}
