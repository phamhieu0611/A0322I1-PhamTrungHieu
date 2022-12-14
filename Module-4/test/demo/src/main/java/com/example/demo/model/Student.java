package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer studentId;
    @NotEmpty(message = "Tên không được phép để trống.")
    @Size(min = 5, max = 45, message = "Tên phải có ít nhất là 5 và nhiều nhất là 45 ký tự.")
    private String studentName;
    private boolean gender;
//    @NotEmpty(message = "Không được để trống ngày sinh.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "classroom_classroomId")
    private Classroom classroom;
    @Min(value = 0, message = "Điểm không được nhỏ hơn 0.")
    @Max(value = 10, message = "Điểm không được lớn hơn 10.")
    private int point;
    @NotEmpty(message = "Số điện thoại không được để trống")
    private String phoneNumber;

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
