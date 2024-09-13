package org.example.assignment2spring;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
public class Assignment2SpringApplication {

    public static void main(String[] args) {
        // Create and run Screamer service
        SpringApplicationBuilder screamerApp = new SpringApplicationBuilder(Assignment2SpringApplication.class);
        screamerApp.properties(
                "server.port=5050",
                "spring.application.name=Screamer",
                "eureka.client.service-url.defaultZone=http://localhost:8761/eureka/",
                "eureka.instance.prefer-ip-address=true"
        );
        screamerApp.build().run(args);  // Run Screamer service on port 5050

        // Create and run Recommendation service
        SpringApplicationBuilder recommendationApp = new SpringApplicationBuilder(Assignment2SpringApplication.class);
        recommendationApp.properties(
                "server.port=8333",
                "spring.application.name=RecommendationService",
                "eureka.client.service-url.defaultZone=http://localhost:8761/eureka/",
                "eureka.instance.prefer-ip-address=true"
        );
        recommendationApp.build().run(args);  // Run Recommendation service on port 8333
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
        // Create and save movie entries
        Movies m = new Movies();
        m.setTitle("Getout");
        m.setSubGenre("Action");
        m.setDescription("When African-American man goes to visit Caucasian parents something's off");
        m.setUrl("https://www.youtube.com/embed/y1OhC9h3flY?si=lmulPcEtFJcbg92Z");
        moviesRepository.save(m);
        movieController.update(m.getId(), m);

        Movies m1 = new Movies();
        m1.setTitle("Hereditary");
        m1.setSubGenre("Comedy");
        m1.setDescription("Annie is devastated along with her family following her mother’s death. Odd things begin happening as the truth about Annie's family starts to emerge.");
        m1.setUrl("https://www.youtube.com/embed/-sM8Jrcbxdc?si=LrwCxvIWrWviyCDO");
        moviesRepository.save(m1);
        movieController.update(m1.getId(), m1);

        // Additional movie entries
        Movies m2 = new Movies();
        m2.setTitle("The Conjuring");
        m2.setSubGenre("Mistry");
        m2.setDescription("Rod and Carolyn find their pet dog dead and experience a spirit that harms their daughter.");
        m2.setUrl("https://www.youtube.com/embed/JhMWopjJiI8?si=4iyYIe1xsWrDdaYG");
        moviesRepository.save(m2);

        Movies m3 = new Movies();
        m3.setTitle("Say it");
        m3.setSubGenre("Action");
        m3.setDescription("A Chinese immigrant must connect with different versions of herself to save the universe.");
        m3.setUrl("https://www.youtube.com/embed/JjBYmLxmT_U?si=EXJZCg7_CSgZUA8I");
        moviesRepository.save(m3);
        movieController.update(m3.getId(), m3);

        Movies m4 = new Movies();
        m4.setTitle("Interstellar");
        m4.setSubGenre("Melodrama");
        m4.setDescription("A NASA pilot turned farmer must find a new Earth.");
        m4.setUrl("https://www.youtube.com/embed/s_M1t0HE-Kk?si=oN8dQ9vY6YGPaufW");
        moviesRepository.save(m4);
        movieController.update(m4.getId(), m4);

        Movies m5 = new Movies();
        m5.setTitle("The Exorcist");
        m5.setSubGenre("Si-Fi");
        m5.setDescription("An actress notices dangerous changes in her 12-year-old daughter.");
        m5.setUrl("https://www.youtube.com/embed/bSxuXQCEC7M?si=aPw7kcVFWW-QwMER");
        moviesRepository.save(m5);
        movieController.update(m5.getId(), m5);

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

        // Log output
        System.out.println("Movies created: " + moviesRepository.findAll());
        System.out.println("Users created: " + customerRepository.findAll());
    }
}
