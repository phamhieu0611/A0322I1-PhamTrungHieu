package com.exam.examdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamDemoApplication {


    public static void main(String[] args) {
       String s1="A",s2="B",s3="C";
       s2.trim();s3.concat("D");
        System.out.println(s1+s2+s3);
    }
}
