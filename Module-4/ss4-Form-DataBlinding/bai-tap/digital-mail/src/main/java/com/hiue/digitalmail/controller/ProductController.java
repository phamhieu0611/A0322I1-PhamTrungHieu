package com.hiue.digitalmail.controller;

import com.hiue.digitalmail.model.Product;
import com.hiue.digitalmail.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("/list")
    public ModelAndView showList(){
        List<Product> products = iProductService.findAll();
        return new ModelAndView("see", "products", products);
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("update") Product update){
        return new ModelAndView("settings", "update", update);
    }
}
