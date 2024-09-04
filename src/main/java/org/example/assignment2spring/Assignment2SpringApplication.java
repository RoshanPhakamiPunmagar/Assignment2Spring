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
        m.setTitle("Intersteller");
        m.setDescription("When a ex-Nasa pilot and a present farmer must do what it takes to find new earth");
        m.setUrl("https://www.youtube.com/embed/s_M1t0HE-Kk?si=oN8dQ9vY6YGPaufW");
        moviesRepository.save(m); // Save and automatically generate ID
        movieController.update(m.getId(), m); // Use the generated ID for updating

        Movies m1 = new Movies();
        m1.setTitle("Say it");
        m1.setDescription("A chinese immigrant must connect with different parallel version of herself to save the universe");
        m1.setUrl("https://www.youtube.com/embed/JjBYmLxmT_U?si=EXJZCg7_CSgZUA8I");
        moviesRepository.save(m1); // Save and automatically generate ID
        movieController.update(m1.getId(), m1); // Use the generated ID for updating

        Movies m2 = new Movies();
        m2.setTitle("Intersteller");
        m2.setDescription("When a ex-Nasa pilot and a present farmer must do what it takes to find new earth");
        m2.setUrl("https://www.youtube.com/embed/s_M1t0HE-Kk?si=oN8dQ9vY6YGPaufW");
        moviesRepository.save(m2); // Save and automatically generate ID
        movieController.update(m2.getId(), m2); // Use the generated ID for updating

        Movies m3 = new Movies();
        m3.setTitle("Say it");
        m3.setDescription("A chinese immigrant must connect with different parallel version of herself to save the universe");
        m3.setUrl("https://www.youtube.com/embed/JjBYmLxmT_U?si=EXJZCg7_CSgZUA8I");
        moviesRepository.save(m3); // Save and automatically generate ID
        movieController.update(m3.getId(), m3); // Use the generated ID for updating


        Movies m4 = new Movies();
        m4.setTitle("Intersteller");
        m4.setDescription("When a ex-Nasa pilot and a present farmer must do what it takes to find new earth");
        m4.setUrl("https://www.youtube.com/embed/s_M1t0HE-Kk?si=oN8dQ9vY6YGPaufW");
        moviesRepository.save(m4); // Save and automatically generate ID
        movieController.update(m4.getId(), m4); // Use the generated ID for updating

        Movies m5 = new Movies();
        m5.setTitle("Say it");
        m5.setDescription("A chinese immigrant must connect with different parallel version of herself to save the universe");
        m5.setUrl("https://www.youtube.com/embed/JjBYmLxmT_U?si=EXJZCg7_CSgZUA8I");
        moviesRepository.save(m5); // Save and automatically generate ID
        movieController.update(m5.getId(), m5); // Use the generated ID for updating

        System.out.println("Movies created: " + moviesRepository.findAll());
    }
}
