package com.example.WebApp;

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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

@Configuration
class _SecurityConfiguration {
    
    @Autowired
    private ScreamerClient screamerClient;


    
    @Bean
    public UserDetailsService userDetailsService(){
        return  email->userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
    
   

    @Bean
    public InMemoryUserDetailsManager _userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user").password("password").roles("USER").build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin").password("password").roles("ADMIN").roles("USER").build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        manager.createUser(admin);
        return manager;
    }

    @Bean
    SecurityFilterChain _filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request
                        -> request.requestMatchers(HttpMethod.GET, "/user/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/admin/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .build();
    }
}

