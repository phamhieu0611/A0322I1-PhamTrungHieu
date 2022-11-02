package com.hiue.yte.controller;

import com.hiue.yte.model.ToKhaiYTe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/yte")
public class ToKhaiYTeController {

    private static Map<String, String> stringsPhuongTien = new LinkedHashMap<>();

    static {
        stringsPhuongTien.put("tauBay","Tàu bay");
        stringsPhuongTien.put("tauThuyen","Tàu Thuyền");
        stringsPhuongTien.put("oto","ô tô");
        stringsPhuongTien.put("anthor","Khác");
    }

    @GetMapping("/add")
    String showToKhaiYTe(Model model){
        model.addAttribute("toKhaiYTe",new ToKhaiYTe());
        model.addAttribute("phuongTiens",stringsPhuongTien);
        return "home";
    }

    @PostMapping("/add")
    String showDienToKhaiYTe(Model model, @ModelAttribute ToKhaiYTe toKhaiYTe){
        model.addAttribute("toKhaiYTe",toKhaiYTe);
        return "result";
    }
}
