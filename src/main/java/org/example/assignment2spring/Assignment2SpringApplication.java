package org.example.assignment2spring;

import org.example.assignment2spring.controllers.RecommendationController;
import org.example.assignment2spring.controllers.MovieController;
import org.example.assignment2spring.entity.Customer;
import org.example.assignment2spring.entity.Movies;
import org.example.assignment2spring.entity.Recommendation;
import org.example.assignment2spring.repos.RecommendationRepository;
import org.example.assignment2spring.repos.MoviesRepository;
import org.example.assignment2spring.repos.CustomerRepository;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Assignment2SpringApplication {

    public static void main(String[] args) {
        //SpringApplication.run(Assignment2SpringApplication.class, args);
        SpringApplicationBuilder eureka = new SpringApplicationBuilder(Assignment2SpringApplication.class);
        eureka.properties("server.port=8761");
        eureka.properties("eureka.client.register-with-eureka=false");
        eureka.properties("eureka.client.fetch-registry=false");
        eureka.run(args);
    }

}

@Component
@Data
class AppInit implements ApplicationRunner {

    private final MovieController movieController;
    private final MoviesRepository moviesRepository;
    private final RecommendationRepository recommendationRepository;
    private final CustomerRepository customerRepository;
    private final RecommendationController recomendationController;

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

        Customer cust = new Customer();
        cust.setName("TestCust");
        customerRepository.save(cust);
        Recommendation testRecommendation = new Recommendation();

        testRecommendation.setCustomer(cust);
        testRecommendation.setMovie(m1);
        recommendationRepository.save(testRecommendation);
        System.out.println("Movies created: " + moviesRepository.findAll());
        System.out.println("recomendations " + recommendationRepository.findAll());

    }
}
