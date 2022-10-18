package com.example.bai2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/directory")
public class DirectoryController {
    @GetMapping()
    public String showDirectory(){
        return "directory";
    }
    @GetMapping("/search")
    public String directory(Model model, @RequestParam(defaultValue = "") String search){
        String result = null;
        Map<String, String> map = new LinkedHashMap<>();
        map.put("yellow", "vàng");
        map.put("blue", "xanh dương");
        map.put("Green", "xanh lá");
        map.put("red", "đỏ");
        map.put("black", "đen");
        map.put("white", "trắng");
        map.put("pink", "hồng");
        result = map.get(search);
        model.addAttribute("result", result);
        return "directory";
    }
}
