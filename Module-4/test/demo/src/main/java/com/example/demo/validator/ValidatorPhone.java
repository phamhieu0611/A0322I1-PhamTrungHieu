package com.example.demo.validator;

import com.example.demo.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ValidatorPhone implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        String phoneNumber = student.getPhoneNumber();
        if (phoneNumber.length()!=10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }if (!phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        Date datePublish = student.getBirthday();
        if (datePublish == null ) {
            errors.rejectValue("birthday", "book.create.publishDate.afternow");
        }
    }
}
