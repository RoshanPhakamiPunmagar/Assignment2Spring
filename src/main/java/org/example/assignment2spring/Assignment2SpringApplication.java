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
        m.setTitle("Getout");
        m.setDescription("When African-American man goes to visit Caucasian parents somthing's off");
        m.setUrl("https://www.youtube.com/embed/y1OhC9h3flY?si=lmulPcEtFJcbg92Z");
        moviesRepository.save(m);
        movieController.update(m.getId(), m);

        Movies m1 = new Movies();
        m1.setTitle("Hereditary");
        m1.setDescription("Annie is devastated along with the rest of her family following the death of her mother. Before long, odd things begin happening as the terrible truth about Annie's family starts to emerge.");
        m1.setUrl("https://www.youtube.com/embed/-sM8Jrcbxdc?si=LrwCxvIWrWviyCDO");
        moviesRepository.save(m1);
        movieController.update(m1.getId(), m1);



        Movies m2 = new Movies();
        m2.setTitle("The Conjuring");
        m2.setDescription("Rod and Carolyn find their pet dog dead under mysterious circumstances and experience a spirit that harms their daughter Andrea. They finally call investigators who can help them get out of the mess.");
        m2.setUrl("https://www.youtube.com/embed/JhMWopjJiI8?si=4iyYIe1xsWrDdaYG");
        moviesRepository.save(m2);


        Movies m3 = new Movies();
        m3.setTitle("Say it");
        m3.setDescription("A chinese immigrant must connect with different parallel version of herself to save the universe");
        m3.setUrl("https://www.youtube.com/embed/JjBYmLxmT_U?si=EXJZCg7_CSgZUA8I");
        moviesRepository.save(m3);
        movieController.update(m3.getId(), m3);


        Movies m4 = new Movies();
        m4.setTitle("Intersteller");
        m4.setDescription("When a ex-Nasa pilot and a present farmer must do what it takes to find new earth");
        m4.setUrl("https://www.youtube.com/embed/s_M1t0HE-Kk?si=oN8dQ9vY6YGPaufW");
        moviesRepository.save(m4);
        movieController.update(m4.getId(), m4);

        Movies m5 = new Movies();
        m5.setTitle("The Exorcist");
        m5.setDescription("An actress notices dangerous changes in the behavior and physical make-up of her 12-year-old daughter. Meanwhile, a young priest begins to doubt his faith while dealing with his mother's sickness.");
        m5.setUrl("https://www.youtube.com/embed/bSxuXQCEC7M?si=aPw7kcVFWW-QwMER");
        moviesRepository.save(m5); // Save and automatically generate ID
        movieController.update(m5.getId(), m5);

        System.out.println("Movies created: " + moviesRepository.findAll());
    }
}
