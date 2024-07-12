package com.example.partA;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthorizationConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config -> {
            config.requestMatchers(HttpMethod.GET,"/shop").permitAll();
            config.requestMatchers(HttpMethod.GET,"/orders").hasAnyRole("finance","sales");
            config.requestMatchers(HttpMethod.GET,"/payments").hasRole("finance");
        }).httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
