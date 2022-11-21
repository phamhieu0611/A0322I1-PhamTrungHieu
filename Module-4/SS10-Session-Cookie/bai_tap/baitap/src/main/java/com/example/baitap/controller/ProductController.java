package com.example.baitap.controller;

import com.example.baitap.model.Cart;
import com.example.baitap.model.Product;
import com.example.baitap.service.IServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
//@RequestMapping("/home")
public class ProductController {
    @Autowired
    IServiceImpl iService;
    @ModelAttribute("cart")
    public Cart setUpProduct(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        return new ModelAndView("shop", "products", iService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable("id") Product product) {
        return new ModelAndView("detail", "product", product);
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable long id, @SessionAttribute("cart") Cart cart,
                            @RequestParam("action") String action){
        Optional<Product> productOptional =iService.findById(id);
        if (!productOptional.isPresent()){
            return "error.404";
        }
        if (action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/des/{id}")
    public String desOutCart(@PathVariable long id, @ModelAttribute Cart cart,
                             @RequestParam("action") String action){
        Optional<Product> productOptional = iService.findById(id);
        if (!productOptional.isPresent()){
            return "error.404";
        }if (action.equals("show")){
            cart.desProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.desProduct(productOptional.get());
        return "redirect:/shop";
    }

//    @GetMapping("delete/{id}")
//    public String deleteProduct(@PathVariable("id") Product product){
//    }
}