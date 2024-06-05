package com.example.lab.setup;

import com.example.lab.auth.filter.JWTFilter;
import com.example.lab.common.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private JWTFilter jwtFilter;

    public WebSecurityConfig() {
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/", "/auth/**").permitAll()
//                .requestMatchers("/admin/**").hasAuthority(Roles.ADMIN.getRole())
//                .requestMatchers("/posts/**", "/users/**").hasAnyAuthority(Roles.ADMIN.getRole(), Roles.USER.getRole())
//                .anyRequest().authenticated()
//        );
        http.authorizeHttpRequests((request) -> request.requestMatchers("/", "/auth/**").permitAll());
        http.authorizeHttpRequests((request) -> request.requestMatchers("/admin/**").hasAuthority(Roles.ADMIN.getRole()));
        http.authorizeHttpRequests((request) -> request.requestMatchers("/posts/**", "/users/**").hasAnyAuthority(Roles.ADMIN.getRole(), Roles.USER.getRole()));

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
