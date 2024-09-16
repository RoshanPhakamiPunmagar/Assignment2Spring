package com.example.Database;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class DatabaseApplication {

    public static void main(String[] args) {

        SpringApplicationBuilder DatabaseService = new SpringApplicationBuilder(DatabaseApplication.class);
        DatabaseService.properties("server.port=8000");
        // #comment in application.properties
        DatabaseService.properties("spring.application.name=Database");
        DatabaseService.properties("eureka.client.service-url.defaultZone=http://localhost:8761/eureka/");
        DatabaseService.properties("eureka.instance.prefer-ip-address=true");

        DatabaseService.run(args);
    }
}

@Component
@Data
@Transactional
class AppInit implements ApplicationRunner {

    private final MovieRepository moviesRepository;
    private final WatchListRepository watchListRepository;
    private final CustomerRepository customerRepository;
    private final RecommendationRepository recommendationRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create and save movie entries

        Movie m = new Movie();
        m.setTitle("Getout");
        m.setSubGenre("Action");
        m.setDescription("When African-American man goes to visit Caucasian parents something's off");
        m.setUrl("https://www.youtube.com/embed/y1OhC9h3flY?si=lmulPcEtFJcbg92Z");
        moviesRepository.save(m);

        Movie m1 = new Movie();
        m1.setTitle("Hereditary");
        m1.setSubGenre("Comedy");
        m1.setDescription("Annie is devastated along with her family following her mother’s death. Odd things begin happening as the truth about Annie's family starts to emerge.");
        m1.setUrl("https://www.youtube.com/embed/-sM8Jrcbxdc?si=LrwCxvIWrWviyCDO");
        moviesRepository.save(m1);

        // Additional movie entries
        Movie m2 = new Movie();
        m2.setTitle("The Conjuring");
        m2.setSubGenre("Mistry");
        m2.setDescription("Rod and Carolyn find their pet dog dead and experience a spirit that harms their daughter.");
        m2.setUrl("https://www.youtube.com/embed/JhMWopjJiI8?si=4iyYIe1xsWrDdaYG");
        moviesRepository.save(m2);

        Movie m3 = new Movie();
        m3.setTitle("Say it");
        m3.setSubGenre("Action");
        m3.setDescription("A Chinese immigrant must connect with different versions of herself to save the universe.");
        m3.setUrl("https://www.youtube.com/embed/JjBYmLxmT_U?si=EXJZCg7_CSgZUA8I");
        moviesRepository.save(m3);

        Movie m4 = new Movie();
        m4.setTitle("Interstellar");
        m4.setSubGenre("Melodrama");
        m4.setDescription("A NASA pilot turned farmer must find a new Earth.");
        m4.setUrl("https://www.youtube.com/embed/s_M1t0HE-Kk?si=oN8dQ9vY6YGPaufW");
        moviesRepository.save(m4);

        Movie m5 = new Movie();
        m5.setTitle("The Exorcist");
        m5.setSubGenre("Si-Fi");
        m5.setDescription("An actress notices dangerous changes in her 12-year-old daughter.");
        m5.setUrl("https://www.youtube.com/embed/bSxuXQCEC7M?si=aPw7kcVFWW-QwMER");
        moviesRepository.save(m5);

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

        WatchList list = new WatchList();
        list.addMovie(m1);
        list.addMovie(m2);
        list.setCustID(user1.getId());
        watchListRepository.save(list);

        // Log output
        System.out.println("Movies created: " + moviesRepository.findAll());
        System.out.println("Users created: " + customerRepository.findAll());
        System.out.println("WatchList created: " + watchListRepository.findAll());

    }
}
