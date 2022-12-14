package com.exam.finalmodule4.controller;

import com.exam.finalmodule4.dto.SesssionTimKiem;
import com.exam.finalmodule4.model.Giaodich;
import com.exam.finalmodule4.service.GiaoDichService;
import com.exam.finalmodule4.service.KhachHangService;
import com.exam.finalmodule4.validator.ValidatorGiaoDich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/giaodich")
@SessionAttributes("sesssionTimKiem")
public class ControllerGiaoDich {
    @Autowired
    ValidatorGiaoDich validatorGiaoDich;

    @Autowired
    GiaoDichService giaoDichService;

    @Autowired
    KhachHangService khachHangService;

    @ModelAttribute("sesssionTimKiem")
    public SesssionTimKiem setUp(){
            return new SesssionTimKiem("");
    }

    @GetMapping("/list")
    public ModelAndView tatca(Pageable pageable,
                                @ModelAttribute(name = "sesssionTimKiem") SesssionTimKiem sesssionTimKiem,
                                @RequestParam(required = false) String timkiem){
        if (timkiem != null){
            sesssionTimKiem.setValue(timkiem);

        }
            return new ModelAndView("home", "giaodichs",
                    giaoDichService.timkiemtheotenkhachhangorloaigiaodich(pageable, sesssionTimKiem.getValue()));
    }

    @GetMapping("/themmoi")
    public ModelAndView createform(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("giaodich", new Giaodich());
        modelAndView.addObject("khachhang", khachHangService.danhsach());
        return modelAndView;
    }

    @PostMapping("/themmoi")
    public String createNew(@Valid @ModelAttribute("giaodich") Giaodich giaodich, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model){
        validatorGiaoDich.validate(giaodich, bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("khachhang", khachHangService.danhsach());
            return "create";
        }
        giaoDichService.taomoi(giaodich);
        redirectAttributes.addFlashAttribute("message",
                "Add student: " + giaodich.getMaGiaoDich() + " done!");
        return "redirect:/giaodich/list";
    }
}
