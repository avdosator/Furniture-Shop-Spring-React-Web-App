package com.avdo.spring.app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class WebConfig {

    private final String[] allowedHeaders = {"Authorization", "Content-Type"};

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        //.allowedOrigins(/*"http://localhost:5173"*/"https://hoppscotch.io/")
                        .allowedOriginPatterns("*")
                        .allowedMethods("GET", "POST")
                        .allowedHeaders(allowedHeaders)
                        .allowCredentials(true);
            }
        };
    }
}
