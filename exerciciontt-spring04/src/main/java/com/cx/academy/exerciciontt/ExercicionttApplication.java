package com.cx.academy.exerciciontt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExercicionttApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExercicionttApplication.class, args);

            System.out.println(new BCryptPasswordEncoder().encode("senha123"));
    }

}
