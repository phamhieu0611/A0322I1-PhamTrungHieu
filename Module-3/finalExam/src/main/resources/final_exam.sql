create database final_exam;
use final_exam;

create table category (
category_id int,
category_name varchar(255),
primary key (category_id)
);

create table product (
product_id int,
name_product varchar (255),
pice double,
quantity int,
color varchar(255),
category_id int default null,
primary key (product_id),
  CONSTRAINT s_category FOREIGN KEY (category_id) REFERENCES category (category_id)
);