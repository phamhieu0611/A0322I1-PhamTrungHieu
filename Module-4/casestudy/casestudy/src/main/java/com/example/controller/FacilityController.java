package com.example.controller;

import com.example.model.facility.Facility;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import com.example.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

//    @GetMapping("/list")
//    public String showList(@PageableDefault(value = 5) Pageable pageable,
//                           @RequestParam(value = "nameSearch" ,defaultValue = "") String nameSearch,
//                           Model model){
//        model.addAttribute("listFacility",iFacilityService.searchFacility(nameSearch,pageable));
//        model.addAttribute("facilityType",iFacilityTypeService.findAll());
//        model.addAttribute("rentType",iRentTypeService.findAll());
//        model.addAttribute("nameSearch",nameSearch);
//        return "/facility/list";
//    }

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch" ,defaultValue = "" ,required = false) String nameSearch,
                           @RequestParam(value = "facilityType" ,defaultValue = "" ,required = false) String facilityType,
                           Model model){
        model.addAttribute("listFacility",iFacilityService.searchFacility2(nameSearch,facilityType,pageable));
//        model.addAttribute("facilityType",iFacilityTypeService.findAll());
//        model.addAttribute("rentType",iRentTypeService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("facilityType",facilityType);
        return "/facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("listFacilityType",iFacilityTypeService.findAll());
        model.addAttribute("listRentType",iRentTypeService.findAll());
        return "/facility/create";
    }

    @PostMapping("/create")
    public String saveFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        return "redirect:/facility/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") Integer id,RedirectAttributes redirectAttributes){
        iFacilityService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("messDelete","Xóa dịch vụ " +
                iFacilityService.findById(id).get().getName() +"thành công");
        return "redirect:/facility/list";
    }


    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model){
        model.addAttribute("facility",iFacilityService.findById(id).get());
        model.addAttribute("listFacilityType",iFacilityTypeService.findAll());
        model.addAttribute("listRentType",iRentTypeService.findAll());
        return "/facility/update";
    }

    @PostMapping("/update")
    public String updateFacility(@ModelAttribute Facility facility,RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("messUpdate","Cập nhật thành công "+facility.getName());
        return "redirect:/facility/list";
    }
}
