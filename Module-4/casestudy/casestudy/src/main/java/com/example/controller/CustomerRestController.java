package com.example.controller;

import com.example.model.Test;
import com.example.model.contract.ContractDetail;
import com.example.service.ICustomerRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/customerRest")
public class CustomerRestController {

    @Autowired
    private ICustomerRestService iCustomerRestService;

    @GetMapping("/webServiceShowData/{id}")
    public ResponseEntity<List<ContractDetail>> viewContractDetail(@PathVariable int id){
        List<ContractDetail> contractDetailList = iCustomerRestService.showAttach(id);
        if(contractDetailList.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(contractDetailList,HttpStatus.OK);
    }
}
