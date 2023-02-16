package com.exam.examdemo.validator;

import com.exam.examdemo.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ValidatorStudent implements Validator {
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
        if (datePublish == null) {
            errors.rejectValue("birthday", "book.create.publishDate.empty");
        }if (datePublish.before(new Date(2004, 12, 16))){
            errors.rejectValue("birthday", "book.create.publishDate.dayBefore");

        }
    }
}
