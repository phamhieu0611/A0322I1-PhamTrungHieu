package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;
    private String classroomName;
    @OneToMany(mappedBy = "classroom")
    @JsonBackReference
    private Set<Student> students;

    public Classroom() {
    }

    public Integer getcClassroomId() {
        return classroomId;
    }

    public void setcClassroomId(Integer cId) {
        this.classroomId = cId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String CName) {
        this.classroomName = CName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
