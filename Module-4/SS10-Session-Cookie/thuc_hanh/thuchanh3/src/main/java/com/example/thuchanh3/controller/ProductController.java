package com.example.thuchanh3.controller;

import com.example.thuchanh3.model.Cart;
import com.example.thuchanh3.model.Product;
import com.example.thuchanh3.service.IServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IServiceImpl iServicel;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iServicel.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart,
                            @RequestParam("action") String action){
        Optional<Product> productOptional = iServicel.findById(id);
        if (!productOptional.isPresent()){
            return "/error.404";
        }if (action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/des/{id}")
    public String desOutCart(@PathVariable Long id, @ModelAttribute Cart cart,
                             @RequestParam("action") String action){
        Optional<Product> productOptional = iServicel.findById(id);
        if (!productOptional.isPresent()){
            return "/error.404";
        }if (action.equals("show")){
            cart.desProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.desProduct(productOptional.get());
        return "redirect:/shop";
    }
}