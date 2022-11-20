package com.example.book.controller;

import com.example.book.exeption.OutOfBookException;
import com.example.book.model.Book;
import com.example.book.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/book")
public class RentBookController {

    @Autowired
    IService iService;

    @GetMapping("list")
    public ModelAndView showPaging(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort){
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("quantity").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("quantity").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, order);
        return new ModelAndView("list", "books", iService.findAll(pageable));
    }

    @GetMapping("create")
    public ModelAndView showCreate(){
        return new ModelAndView("create", "book", new Book());
    }

    @PostMapping("create")
    public String createBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes){
        iService.save(book);
        redirectAttributes.addFlashAttribute("message", "Create Blog: " + book.getAuthor() + " done!");
        return "redirect:/book/list";
    }

    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable("id") Book book) {
        return new ModelAndView("create", "book", book);
    }

    @GetMapping("borrow/{id}")
    public String borrow(@PathVariable("id") Book book) throws OutOfBookException {
        if (book.getQuantity() == 0){
            throw new OutOfBookException();
        }else {
            book.setQuantity(book.getQuantity()-1);
            iService.save(book);
            return "redirect:/book/list";
        }
    }
    @ExceptionHandler(OutOfBookException.class)
    public String OutOfBook(){
        return "/outOfBook";
    }

    @GetMapping("pay/{id}")
    public String payBook(@PathVariable("id") Book book){
        book.setQuantity(book.getQuantity()+1);
        iService.save(book);
        return "redirect:/book/list";
    }
}
