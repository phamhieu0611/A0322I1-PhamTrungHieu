package com.example.register_form.model;

import javax.persistence.*;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Size(min = 5, max = 45, message = "{string.size}")
    private String firstName;

    @Size(min = 5, max = 45, message = "{string.size}")
    private String lastName;

    @Min(value = 18, message = "{string.age}")
    private int age;

    private String phoneNumber;

    public User() {
    }

    public User(int userId, String firstName, String lastName, int age, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String number = user.getPhoneNumber();
        if (number.length() > 11 || number.length() < 10){
            errors.rejectValue("phoneNumber", "number.empty");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "number.matches");
        }

        String fName = user.getFirstName();
        if (fName.length() < 5 || fName.length()>45){
            errors.rejectValue("firstName", "user.create.name.size"
                    , new String[]{"5", "45"}, "Độ dài tên chưa chính xác.");
        }

        String lName = user.getLastName();
        if (lName.length() < 5 || lName.length() > 45){
            errors.rejectValue("lastName", "user.create.name.size"
                    , new String[]{"5", "45"}, "Độ dài tên chưa chính xác.");
        }

        int age = user.getAge();
        if (age < 18){
            errors.rejectValue("age", "user.create.age.size", "Tuổi chưa chính xác.");
        }
    }
}
