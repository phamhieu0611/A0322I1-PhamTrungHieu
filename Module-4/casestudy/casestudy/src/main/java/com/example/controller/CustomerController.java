package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;


//
//    @GetMapping("/list")
//    public String showList(@PageableDefault(value = 5) Pageable pageable,
//                           @RequestParam(value = "nameSearch" ,defaultValue = "") String nameSearch,
//                           @RequestParam(value = "emailSearch",defaultValue = "") String emailSearch,
//                           @RequestParam(value = "addressSearch",defaultValue = "") String addressSearch,
//                           Model model){
//        model.addAttribute("listCustomer",iCustomerService.searchCustomer(nameSearch,emailSearch,addressSearch,pageable));
////        model.addAttribute("listCustomerType",iCustomerTypeService.findAll());
//        model.addAttribute("nameSearch",nameSearch);
//        model.addAttribute("emailSearch",emailSearch);
//        model.addAttribute("addressSearch",addressSearch);
//        return "/customer/list";
//    }

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch" ,defaultValue = "") String nameSearch,
                           @RequestParam(value = "emailSearch",defaultValue = "") String emailSearch,
                           @RequestParam(value = "customerType",defaultValue = "") String customerType,
                           Model model){
        model.addAttribute("listCustomer",iCustomerService.searchCustomer2(nameSearch,emailSearch,customerType,pageable));
        model.addAttribute("listCustomerType",iCustomerTypeService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("emailSearch",emailSearch);
        model.addAttribute("customerType",customerType);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("listCustomerType",iCustomerTypeService.findAll());
        return "/customer/create";
    }


    @PostMapping("/create")
    public String saveCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/customer/create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("messCreate", "Tao moi thanh cong" + customer.getName());
            return "redirect:/customer/list";

        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") Integer id,RedirectAttributes redirectAttributes){
        iCustomerService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("messDelete","Xóa khách hàng" +
                iCustomerService.findById(id).get().getName() +"thành công");
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}-update")
    public String updateCustomer(@PathVariable Integer id,Model model){

        Customer customer = iCustomerService.findById(id).get();
        CustomerDto customerDto = new CustomerDto();

        BeanUtils.copyProperties(customer,customerDto);

        model.addAttribute("listCustomerType",iCustomerTypeService.findAll());

        model.addAttribute("customerDto",customerDto);

        return "customer/update";
    }

    @PostMapping("/update")
    public String saveCustomerUpdate(@Validated @ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/customer/update";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("messCreate", "Chỉnh sửa thành công" + customer.getName());
            return "redirect:/customer/list";

        }
    }

}
