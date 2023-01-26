package com.demo.academiacx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AcamiacxdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcamiacxdemoApplication.class, args);
        //System.out.printf((new BCryptPasswordEncoder().encode("senha123")));
    }

}
