package com.example.thuc_hanhphone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartphoneController {

    @GetMapping("/")
    public String showIndex(){
        return "/index";
    }
}
