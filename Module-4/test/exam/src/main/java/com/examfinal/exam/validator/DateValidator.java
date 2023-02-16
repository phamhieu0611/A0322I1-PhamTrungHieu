package com.examfinal.exam.validator;

import com.examfinal.exam.model.Bill;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class DateValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Bill.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Bill bill = (Bill) target;
        Date datePublish = bill.getPublishDate();
        if (datePublish == null) {
            errors.rejectValue("publishDate", "publishDate.edit.empty");
        }if (datePublish.after(new Date(2022, 12, 16))){
            errors.rejectValue("publishDate", "publishDate.edit.dayAfter");
        }
    }
}
