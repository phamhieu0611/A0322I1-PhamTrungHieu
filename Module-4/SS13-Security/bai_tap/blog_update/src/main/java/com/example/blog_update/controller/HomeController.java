package com.example.blog_update.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {
    @GetMapping("/home")
    public String showHomePage(){
        return "newPagin/home";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "newPagin/myLogin";
    }
}
