package com.avdo.spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SpringAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringAppApplication.class, args);
    }

}
