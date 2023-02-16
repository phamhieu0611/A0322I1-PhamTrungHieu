package com.example.demo.controller.loi;

import com.example.demo.controller.SearchSession;
import com.example.demo.model.Student;
import com.example.demo.model.loi.Contract;
import com.example.demo.service.loi.ContactService;
import com.example.demo.service.loi.CustomerService;
import com.example.demo.validator.ValidatorContract;
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
@RequestMapping("/contract")
@SessionAttributes("searchSession")
public class LoiController {
    @Autowired
    ContactService contactService;
    @Autowired
    CustomerService customerService;

    @Autowired
    ValidatorContract validatorContract;

    @ModelAttribute("searchSession")
    public SearchSession setUp(){
        return new SearchSession("");
    }

    @GetMapping("/list")
    public ModelAndView findAll(Pageable pageable,
                                @ModelAttribute(name = "searchSession") SearchSession searchSession,
                                @RequestParam(required = false) String searchVal){
        if (searchVal != null){
            searchSession.setValue(searchVal);
        }
        return new ModelAndView("home123", "contracts",
                contactService.search(pageable, searchSession.getValue()));
    }

    @GetMapping("/create")
    public ModelAndView createform(){
        ModelAndView modelAndView = new ModelAndView("create123");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("customers", customerService.listAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model){
        validatorContract.validate(contract, bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customers", customerService.listAll());
            return "create123";
        }
        contactService.create(contract);
        redirectAttributes.addFlashAttribute("message",
                "Add Contract: " + contract.getContractId() + " done!");
        return "redirect:/contract/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editform(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("customers", customerService.listAll());
        modelAndView.addObject("contract", contactService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        contactService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete contract: " + id + " done!");
        return "redirect:/contract/list";
    }
}
