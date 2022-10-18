package com.example.bai1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")
public class ConvertController {
    @PostMapping()
    public String convert(@RequestParam double tiGia, @RequestParam double tienTe, Model model){
        model.addAttribute("showConvert", tienTe*tiGia);

        return "showConvert";
}
    @GetMapping()
    public String showConvert(){
        return "showConvert";
    }
}
