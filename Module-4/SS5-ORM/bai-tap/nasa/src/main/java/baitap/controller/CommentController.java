package baitap.controller;

import baitap.model.Comment;
import baitap.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("nasa")
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping()
    String getPage(Model model){
        model.addAttribute("commnet",new Comment());
        model.addAttribute("commentList",service.findAll());
        return "create";
    }

    @PostMapping()
    String addComment(@ModelAttribute Comment comment){
        service.save(comment);
        return "redirect:/nasa";
    }

}
