package com.examfinal.exam.controller;

import com.examfinal.exam.dto.SearchSession;
import com.examfinal.exam.model.Bill;
import com.examfinal.exam.service.BillService;
import com.examfinal.exam.service.ProductService;
import com.examfinal.exam.service.TypeProductService;
import com.examfinal.exam.validator.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/bill")
@SessionAttributes("searchSession")
public class BillController {
    @Autowired
    BillService billService;

    @Autowired
    ProductService productService;

    @Autowired
    TypeProductService typeProductService;

    @Autowired
    DateValidator dateValidator;

    @ModelAttribute("searchSession")
    public SearchSession setUp(){
        return new SearchSession();
    }

    @GetMapping("/list")
    public ModelAndView showList(Pageable pageable){
        return new ModelAndView("home", "bills", billService.findAll(pageable));
    }

    @GetMapping("/update/{id}")
    public ModelAndView editform(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("typeProducts", typeProductService.listAll());
        modelAndView.addObject("products", productService.listAll());
        modelAndView.addObject("bills", billService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String editStudent(@PathVariable Integer id,@Valid  @ModelAttribute Bill bill,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model){
        System.out.println(id);
        bill.setBillId(id);
        dateValidator.validate(bill,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("typeProducts", typeProductService.listAll());
            model.addAttribute("products", productService.listAll());
            return "update";
        }
        billService.update(bill);
        redirectAttributes.addFlashAttribute("message",
                "Cập nhật Hóa Đơn mang mã số: " + bill.getBillId() + " có sản phẩm là "
                        + bill.getProduct().getProductName() +" thành công!");
        return "redirect:/bill/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBill(@PathVariable("id") Integer id,
                                Bill bill, RedirectAttributes redirectAttributes){
        billService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "Xóa Hóa Đơn mang mã số: " + bill.getBillId() + " có sản phẩm là "
                        + bill.getProduct().getProductName() +"thành công!");
        return "redirect:/bill/list";
    }
}
