package com.example.a04cinema;

import com.example.a04cinema.entity.Account;
import com.example.a04cinema.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class A04cinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(A04cinemaApplication.class, args);
    }
}
