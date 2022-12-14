package com.example.controller;

import com.example.model.contract.Contract;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;


    @GetMapping("/list")
    public  String showList(@PageableDefault(value = 5) Pageable pageable,
                            @RequestParam(value = "nameCustomer",defaultValue = "") String nameCustomer,
                            Model model){
        model.addAttribute("listContract",iContractService.searchContract(nameCustomer,pageable));
        model.addAttribute("listContractDetail",iContractDetailService.findAll());
        model.addAttribute("nameCustomer",nameCustomer);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
         model.addAttribute("listCustomer",iCustomerService.findAll());
         model.addAttribute("listFacility",iFacilityService.findAll());
         model.addAttribute("listEmployee",iEmployeeService.findAll());
         model.addAttribute("contract",new Contract());
         return "/contract/create";
    }

    @PostMapping("/create")
    public String saveContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
        iContractService.save(contract);
        return "redirect:/contract/list";
    }
}
