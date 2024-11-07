package com.example.libraryManagementSystem.Cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/home").permitAll() // Allow unauthenticated access to "/home"
                        .anyRequest().authenticated()          // Require authentication for all other requests
                )
                .httpBasic()                               // Enable HTTP Basic authentication
                .and()
                .csrf().disable();                         // Disable CSRF for testing (not recommended for production)

        return http.build();
    }

  

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails userDetails =  User.withUsername("admin").password("{noop}admin").roles("LIBRARIAN").build();
        manager.createUser(userDetails);
        return manager;
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin").password("{noop}admin").roles("USER").build());
//        return manager;
//    }
}

/**
 *
 *     @Bean
 *     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 *         http
 *                 .authorizeHttpRequests(auth -> auth
 *                         .anyRequest().authenticated()
 *                         .requestMatchers("/home").permitAll()
 *                 )
 *                 .httpBasic(httpSecurityHttpBasicConfigurer -> {
 *                 });
 *         return http.build();
 *     }
 */