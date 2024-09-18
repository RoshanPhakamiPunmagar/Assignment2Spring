package com.example.databasedao;

import com.example.databasedao.customer.Customer;
import com.example.databasedao.customer.CustomerController;
import com.example.databasedao.customer.CustomerRepository;
import com.example.databasedao.movies.MovieController;
import com.example.databasedao.movies.Movies;
import com.example.databasedao.movies.MoviesRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

@SpringBootApplication @EnableDiscoveryClient
public class DatabaseDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDaoApplication.class, args);
    }

}
@Component
@Data
@Transactional
class AppInit implements ApplicationRunner {

    private final MovieController movieController;
    private final MoviesRepository moviesRepository;
    private final CustomerRepository customerRepository;
    private final CustomerController customerController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create and save movie entries
        Movies m = new Movies();
        m.setTitle("Getout");
        m.setSubGenre("Action");
        m.setDescription("When African-American man goes to visit Caucasian parents something's off");
        m.setUrl("https://www.youtube.com/embed/y1OhC9h3flY?si=lmulPcEtFJcbg92Z");
        moviesRepository.save(m);
        movieController.addMovie(m);

        Movies m1 = new Movies();
        m1.setTitle("Hereditary");
        m1.setSubGenre("Comedy");
        m1.setDescription("Annie is devastated along with her family following her mother’s death. Odd things begin happening as the truth about Annie's family starts to emerge.");
        m1.setUrl("https://www.youtube.com/embed/-sM8Jrcbxdc?si=LrwCxvIWrWviyCDO");
        moviesRepository.save(m1);
        movieController.addMovie(m);

        // Additional movie entries
        Movies m2 = new Movies();
        m2.setTitle("The Conjuring");
        m2.setSubGenre("Mistry");
        m2.setDescription("Rod and Carolyn find their pet dog dead and experience a spirit that harms their daughter.");
        m2.setUrl("https://www.youtube.com/embed/JhMWopjJiI8?si=4iyYIe1xsWrDdaYG");
        moviesRepository.save(m2);
        movieController.addMovie(m);
        Movies m3 = new Movies();
        m3.setTitle("Say it");
        m3.setSubGenre("Action");
        m3.setDescription("A Chinese immigrant must connect with different versions of herself to save the universe.");
        m3.setUrl("https://www.youtube.com/embed/JjBYmLxmT_U?si=EXJZCg7_CSgZUA8I");
        moviesRepository.save(m3);
        movieController.addMovie(m);

        Movies m4 = new Movies();
        m4.setTitle("Interstellar");
        m4.setSubGenre("Melodrama");
        m4.setDescription("A NASA pilot turned farmer must find a new Earth.");
        m4.setUrl("https://www.youtube.com/embed/s_M1t0HE-Kk?si=oN8dQ9vY6YGPaufW");
        moviesRepository.save(m4);
        movieController.addMovie(m);

        Movies m5 = new Movies();
        m5.setTitle("The Exorcist");
        m5.setSubGenre("Si-Fi");
        m5.setDescription("An actress notices dangerous changes in her 12-year-old daughter.");
        m5.setUrl("https://www.youtube.com/embed/bSxuXQCEC7M?si=aPw7kcVFWW-QwMER");
        moviesRepository.save(m5);
        movieController.addMovie(m);

        // Create a new Customer object for Anmol
        Customer c1 = new Customer();
        c1.setName("Anmol");
        c1.setEmail("anmol@gmail.com");
        c1.setPassword("anmol123");
        customerRepository.save(c1);
        customerController.addCustomer(c1);

        // Create a new Customer object for Roshan
        Customer c2 = new Customer();
        c2.setName("Roshan");
        c2.setEmail("roshan@gmail.com");
        c2.setPassword("roshan123");
        customerRepository.save(c2);
        customerController.addCustomer(c2);

        // Create a new Customer object for Caleb
        Customer c3 = new Customer();
        c3.setName("Caleb");
        c3.setEmail("caleb@gmail.com");
        c3.setPassword("caleb123");
        customerRepository.save(c3);
        customerController.addCustomer(c3);

        // Create a new Customer object for Rutvi
        Customer c4 = new Customer();
        c4.setName("Rutvi");
        c4.setEmail("rutvi@gmail.com");
        c4.setPassword("rutvi123");
        customerRepository.save(c4);
        customerController.addCustomer(c4);

    }
}