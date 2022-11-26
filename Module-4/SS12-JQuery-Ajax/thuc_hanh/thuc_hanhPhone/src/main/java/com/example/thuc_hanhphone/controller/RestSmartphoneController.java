package com.example.thuc_hanhphone.controller;

import com.example.thuc_hanhphone.model.SmartPhone;
import com.example.thuc_hanhphone.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class RestSmartphoneController {
    @Autowired
    ISmartPhoneService iSmartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone){
        return new ResponseEntity<>(iSmartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhone(){
        return new ResponseEntity<>(iSmartPhoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphone(){
        return new ModelAndView ("list", "smartphones", iSmartPhoneService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable int id){
        Optional<SmartPhone> smartPhone = iSmartPhoneService.findById(id);
        if (!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartPhoneService.remove(id);
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.NO_CONTENT);
    }
}
