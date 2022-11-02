package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MController {

    @Autowired
    private IService iService;

    @GetMapping()
    public ModelAndView showAll(){
        List<Music> musics = iService.findAll();
        return new ModelAndView("music", "musics", musics);
    }

    @GetMapping("/create")
    public ModelAndView createPage(){
        return new ModelAndView("create", "music", new Music());
    }

    @PostMapping("/create")
    public String createMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
        iService.save(music);
        redirectAttributes.addFlashAttribute("message", "Create Music: " + music.getName() + " done!");
        return "redirect:/music";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable int id){
        return new ModelAndView("update", "music", iService.findById(id));
    }

    @PostMapping("/update/{id}")
    public String updateMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
        iService.update(music);
        redirectAttributes.addFlashAttribute("message", "Update Music: " + music.getName() + " done!");
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable int id){
        iService.delete(iService.findById(id));
        return ("redirect:/music");
    }
}
