package com.example.a04cinema.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @GetMapping("/random")
    public String randomStuff(){
        return ("JWT Hợp lệ mới có thể thấy được message này");
    }
}
