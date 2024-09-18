package com.example.screamerwebapp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

@SpringBootApplication @EnableFeignClients
@EnableDiscoveryClient
public class ScreamerWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreamerWebAppApplication.class, args);
    }

}


@Configuration // Marks this class as a configuration class for Spring.
@EnableWebSecurity // Enables web security for the application.
 class WebSecurityConfiguration  {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain _filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request
                        -> request.requestMatchers(HttpMethod.GET, "/allMovies/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/admin/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}




@Service
@RequiredArgsConstructor
class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerClient custClient;
    

    @Override
    public UserDetails loadUserByUsername(final String email) {
        final Customer cust = this.custClient.getByEmail(email);
        
      
        if (cust == null) {
            System.out.println("Error no user with email: " + email);
        }
        return User.withUsername(cust.getEmail())
                .password(cust.getPassword())
                .authorities("USER")// need to add this to databsae
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}









/*
package com.example.WebApp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class WebAppApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder webApp = new SpringApplicationBuilder(WebAppApplication.class);
        webApp.properties("server.port=8080");
        webApp.properties("spring.application.name=recommendationClient");
        webApp.properties("eureka.client.service-url.defaultZone=http://localhost:8761/eureka/");
        webApp.properties("eureka.instance.prefer-ip-address=true");
        webApp.run(args);
    }

}


@Configuration // Marks this class as a configuration class for Spring.
@EnableWebSecurity // Enables web security for the application.
 class WebSecurityConfiguration  {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain _filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request
                        -> request.requestMatchers(HttpMethod.GET, "/allMovies/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/admin/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}




@Service
@RequiredArgsConstructor
class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ScreamerClient screamerClient;
    

    @Override
    public UserDetails loadUserByUsername(final String email) {
        //final Customer cust = this.screamerClient.getCustomerByEmail(email);
        Customer cust = new Customer();
        cust.setEmail("test1.email.com");
        cust.setPassword("password1");
        if (cust == null) {
            System.out.println("Error no user with email: " + email);
        }
        return User.withUsername(cust.getEmail())
                .password(cust.getPassword())
                .authorities("USER")// need to add this to databsae
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}



*/