package com.example.blog_update.controller;

import com.example.blog_update.model.Blog;
import com.example.blog_update.repository.CategoryRepository;
import com.example.blog_update.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryRepository categoryRepository;

    private Logger logger = Logger.getLogger(BlogController.class.getName());

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @GetMapping("list")
    public String showListBook(@RequestParam(name = "blogName", required = false) String name, Model model, Principal principal) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("blogs", blogService.findByName(name));
        } else {
            model.addAttribute("blogs", blogService.getList());
        }
        System.out.println(principal.getName());
        return "blog";
    }

    @GetMapping("create")
    public ModelAndView displayCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryRepository.findAll());
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return modelAndView;
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Create Blog: " + blog.getAuthor() + " done!");
        return "redirect:/blog/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView displayUpdate(@PathVariable("id") Blog blog){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("categories", categoryRepository.findAll());
        modelAndView.addObject("blog", blogService.getBlogById(blog.getBlogId()));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Blog: " + blog.getAuthor() + " done!");
        return "redirect:/blog/list";
    }

    @GetMapping("listPaging")
    public String showListBookPaging(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "3") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            Model model) {
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("name").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("name").descending();
        }
        Pageable pageable = PageRequest.of(page - 1, size, order);
        model.addAttribute("blogs", blogService.findAll(pageable));
        return "blog";
    }

//    @GetMapping("detail/{id}")
//    public String showDetail(@PathVariable("id") int blog_id, Model model) {
//        model.addAttribute("blog", blogService.getBlogById(blog_id));
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(dateFormat.format(blogService.getBlogById(blog_id).getPublishDate()));
//        return "detail";
//    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Blog blog){
        blogService.deleteBlogById(blog.getBlogId());
        return "redirect:/blog/list";
    }

    @GetMapping("detail2/{id}")
    public ModelAndView showDetail2(@PathVariable("id") Blog blog) {
        return new ModelAndView("detail", "blog", blog);
    }

    @GetMapping("/search/{name}")
    public ModelAndView searchBlog(@PathVariable String name){
//        String name= params.get("blogName");
        List<Blog> blogs = blogService.findByName(name);
        return new ModelAndView("blog","blogs", blogs);
    }
}