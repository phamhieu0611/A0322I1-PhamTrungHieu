package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.ClassroomService;
import com.example.demo.service.StudentService;
import com.example.demo.validator.ValidatorPhone;
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
@RequestMapping("/student")
@SessionAttributes("searchSession")
public class StudentController {

    @Autowired
    ValidatorPhone validatorPhone;
    @Autowired
    StudentService studentService;

    @Autowired
    ClassroomService classroomService;

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
        return new ModelAndView("student/home", "students",
                studentService.searchByNameOrcName(pageable, searchSession.getValue()));
    }

    @GetMapping("/create")
    public ModelAndView createform(){
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("classroom", classroomService.listAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model){
        validatorPhone.validate(student, bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("classroom", classroomService.listAll());
            return "student/create";
        }
        studentService.create(student);
        redirectAttributes.addFlashAttribute("message",
                "Add student: " + student.getStudentName() + " done!");
        return "redirect:/student/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editform(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("classroom", classroomService.listAll());
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@Valid @PathVariable Integer id, @ModelAttribute Student student, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,  Model model){
        student.setStudentId(id);
        validatorPhone.validate(student,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("classroom", classroomService.listAll());
            return "student/edit";
        }
        studentService.update(student);
        redirectAttributes.addFlashAttribute("message",
                "Edit student: " + student.getStudentName() + " done!");
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete student: " + id + " done!");
        return "redirect:/student/list";
    }
}
