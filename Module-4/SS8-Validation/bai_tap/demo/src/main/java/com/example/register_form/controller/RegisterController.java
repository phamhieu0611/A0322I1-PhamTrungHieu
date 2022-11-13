package com.example.register_form.controller;

import com.example.register_form.model.User;
import com.example.register_form.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    IService iService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("register")
    public ModelAndView displayRegister(){
        return new ModelAndView("register", "user", new User());
    }

    @PostMapping("register")
    public String createNewUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "register";
        }
        iService.save(user);
        return "result";
    }
}
