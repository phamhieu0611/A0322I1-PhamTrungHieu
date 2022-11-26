package com.example.blog_update.controller;

import com.example.blog_update.model.Blog;
import com.example.blog_update.model.Category;
import com.example.blog_update.service.BlogService;
import com.example.blog_update.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlog(){
        List<Blog> blogList = blogService.getList();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Blog> getOneBlog(@PathVariable int id){
        Optional<Blog> blog = blogService.findBlogById(id);
        if (!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @GetMapping("cate")
    public ResponseEntity<Iterable<Category>> getCate(){
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("cate/{id}")
    public ResponseEntity<List<Blog>> findBlogs(@PathVariable int id){
        Category category = categoryService.findById(id);
        List<Blog> blogs = blogService.findBlogsByCategory(category);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
