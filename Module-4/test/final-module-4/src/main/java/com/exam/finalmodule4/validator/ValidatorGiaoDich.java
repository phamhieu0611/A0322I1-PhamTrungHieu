package com.exam.finalmodule4.validator;

import com.exam.finalmodule4.model.Giaodich;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ValidatorGiaoDich implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Giaodich.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Giaodich giaodich = (Giaodich) target;
        String maGiaoDich = giaodich.getMaGiaoDich();
        if (maGiaoDich.length() == 0){
            errors.rejectValue("maGiaodich", "maGiaoDich.empty");
        }if (!maGiaoDich.startsWith("MGD-")){
            errors.rejectValue("maGiaoDich", "maGiaoDich.startsWith");
        }
        Date ngayGiaoDich = giaodich.getNgayGiaoDich();
        if (ngayGiaoDich == null ) {
            errors.rejectValue("ngayGiaoDich", "ngayGiaoDich.null");
        }
    }
}
