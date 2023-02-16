package com.exam.examdemo.controller;

import com.exam.examdemo.dto.SearchSession;
import com.exam.examdemo.model.Student;
import com.exam.examdemo.service.ClassnumService;
import com.exam.examdemo.service.StudentService;
import com.exam.examdemo.validator.ValidatorStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/student")
@SessionAttributes("searchSession")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassnumService classnumService;

    @Autowired
    ValidatorStudent validatorStudent;

    @ModelAttribute("searchSession")
    public SearchSession setUp() {
        return new SearchSession("");
    }

    @GetMapping("/list")
    public ModelAndView findAll(Pageable pageable,
                                @ModelAttribute(name = "searchSession") SearchSession searchSession,
                                @RequestParam(required = false) String searchVal) {
        if (searchVal != null) {
            searchSession.setValue(searchVal);
        }
        return new ModelAndView("home", "students", studentService.search(
                pageable, searchSession.getValue()));
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("classnums", classnumService.listAll());
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createAc(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes, Model model) {
        validatorStudent.validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("classnums", classnumService.listAll());
            return "create";
        }
        studentService.create(student);
        redirectAttributes.addFlashAttribute("message",
                "Add Student name: " + student.getName() + " done!");
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, Student student,
                                RedirectAttributes redirectAttributes) {
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete student name: " + student.getName() + " done!");
        return "redirect:/student/list";
    }
}
