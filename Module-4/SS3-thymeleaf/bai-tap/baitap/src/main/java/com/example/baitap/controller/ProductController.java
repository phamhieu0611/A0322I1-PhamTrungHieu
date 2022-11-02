package com.example.baitap.controller;

import com.example.baitap.model.Product;
import com.example.baitap.service.IProductService;
import com.example.baitap.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static IProductService productService = new ProductServiceImpl();

    @GetMapping()
    String showList(Model model){
        model.addAttribute("products",productService.findAll());
        return "list";
    }

    //create
    @GetMapping("/create")
    String pageCreate(@ModelAttribute Product product, Model model){
        model.addAttribute("product",product);
        return "new";
    }

    @PostMapping("/save")
    String addProduct(@ModelAttribute Product product){
        productService.addNew(product);
        return "redirect:/product";
    }

    //edit
    @GetMapping("/{id}/edit")
    String pageEdit(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    String updateProduct(@ModelAttribute Product product) throws Exception {
        productService.updateProduct(product);
        return "redirect:/product";
    }

    //view
    @GetMapping("/{id}/view")
    String pageView(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("product",productService.findById(id));
        return "view";
    }

    //delete
    @GetMapping("/{id}/delete")
    String deleteProduct(@PathVariable int id, Model model) throws Exception {
        productService.delete(id);
        return "redirect:/product";
    }

    //search
    @GetMapping("/search")
    String pageSearch(@RequestParam String search, Model model) throws Exception{
        model.addAttribute("products",productService.findByName(search));
        return "list";
    }
}