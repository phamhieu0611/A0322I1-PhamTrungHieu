package com.example.bai1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculatorform")
    public String showCalculator(){
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(defaultValue = "") String operator, @RequestParam(defaultValue = "") double num1, @RequestParam(defaultValue = "") double num2, Model model){
        double result = 0;
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 + num2;
                break;
            case "*":
                result = num1 + num2;
                break;
            case "/":
                result = num1 + num2;
                break;
        }
        model.addAttribute("result",result);
        return "index";
    }

}
