package com.exam.examdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Classnum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String className;

    private String teacher;

    @OneToMany(mappedBy = "classnum")
    @JsonBackReference
    private Set<Student> set;

    public Classnum() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getSet() {
        return set;
    }

    public void setSet(Set<Student> set) {
        this.set = set;
    }
}
