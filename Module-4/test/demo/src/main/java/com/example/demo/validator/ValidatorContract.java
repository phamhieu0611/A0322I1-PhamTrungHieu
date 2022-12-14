package com.example.demo.validator;

import com.example.demo.model.loi.Contract;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ValidatorContract implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        String contractId = contract.getContractId();
        if (contractId.length()==0){
            errors.rejectValue("contractId", "contractId.empty");
        }if (!contractId.startsWith("MGD-")){
            errors.rejectValue("contractId", "contractId.startsWith");
        }
//        if (!contractId.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("phoneNumber", "phoneNumber.matches");
//        }
        Date datePublish = contract.getContractTime();
        if (datePublish == null) {
            errors.rejectValue("contractTime", "contractTime.empty");
        }
    }
}
