package com.hiue.uploadmusic.controller;

import com.hiue.uploadmusic.model.Music;
import com.hiue.uploadmusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/music")
public class UploadController {
@Autowired
    IService iService;

@GetMapping("/list")
    public ModelAndView showList(){
    List<Music> musics = iService.findAll();
    return new ModelAndView("list", "musics", musics);
}

@GetMapping("/save")
    public String save(Model model){
    List<String> strings = new ArrayList<>();
    strings.add("Cach mang");
    strings.add("Tru tinh");
    strings.add("Dam cuoi");
    strings.add("Tet");

    model.addAttribute("music", new Music());
    model.addAttribute("strings", strings);
    return "save";
}

@PostMapping("/save")
    public String saveMusic (@ModelAttribute("music") Music music, Model model){
    iService.save(music);
    model.addAttribute("list", iService.findAll());
    return "redirect:/music/list";
}
}
