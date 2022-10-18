create database thuetro;

use thuetro;

create table thanhtoan (
ma_thanh_toan int,
loai_thanh_toan varchar(255),
primary key (ma_thanh_toan)
);

create table phongtro (
ma_phong_tro int auto_increment,
ten_nguoi_thue varchar(55),
so_dien_thoai int(12),
ngay_thue datetime,
ma_thanh_toan int,
primary key (ma_phong_tro),
FOREIGN KEY (ma_thanh_toan) REFERENCES thanhtoan (ma_thanh_toan)
);