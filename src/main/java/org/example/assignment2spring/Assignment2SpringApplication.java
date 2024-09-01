package org.example.assignment2spring;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Assignment2SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2SpringApplication.class, args);
    }

}
@Component
@Data @Transactional
class AppInit implements ApplicationRunner {
    private final MovieController movieController;
    private final MoviesRepository moviesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movies m = new Movies();
        m.setTitle("herop");
        m.setUrl("https://www.youtube.com/watch?v=cE7vGF60cRA&pp=ygUNd3Vrb25nIHJldmlldw%3D%3D");
        moviesRepository.save(m); // Save and automatically generate ID
        movieController._update(m.getId(), m); // Use the generated ID for updating

        Movies m1 = new Movies();
        m1.setTitle("Say it");
        m1.setUrl("https://www.youtube.com/watch?v=F64yFFnZfkI");
        moviesRepository.save(m1); // Save and automatically generate ID
        movieController._update(m1.getId(), m1); // Use the generated ID for updating

        System.out.println("Movies created: " + moviesRepository.findAll());
    }


}
