package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IService iService;

    @GetMapping()
    public ModelAndView findAll(){
        List<Blog> blogs = iService.findAll();
        return new ModelAndView("blog", "blogs", blogs);
    }

    @GetMapping("/create")
    public ModelAndView createBlogPage(){
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String createblog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create Blog: " + blog.getAuthor() + " done!");
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateBlogPage(@PathVariable int id){
        return new ModelAndView("update", "blog", iService.findById(id));
    }

    @PostMapping("/update/{id}")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Blog: " + blog.getAuthor() + " done!");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        iService.delete(iService.findById(id));
        return"redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view ( @PathVariable int id, Model model){
        model.addAttribute("blog", iService.findById(id));
        return "detail";
    }
}