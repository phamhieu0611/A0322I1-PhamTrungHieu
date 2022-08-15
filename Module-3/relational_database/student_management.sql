CREATE DATABASE `student_management`;
use student_management;
create table Student(
	id int auto_increment primary key,
    name varchar(50),
    gender bit,
    age int,
    `class` varchar(10),
    country varchar(50)
) ;
create table teacher(
	id int auto_increment primary key,
    name varchar(50),
    gender bit,
    age int,
    `class` varchar(10),
    country varchar(50)
) ;
create table `class`(
	id int auto_increment primary key,
    name varchar(50)
) ;