package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public  String home(){
        return "/home";
    }

    @GetMapping("/customer")
    public String customer(){
        return "/customer/customerHome";
    }

    @GetMapping("facility")
    public String facility(){
        return "/facility/facilityHome";
    }
}
