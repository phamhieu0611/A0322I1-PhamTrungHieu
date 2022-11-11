create database thuetro;

use thuetro;

create table thanhtoan (
ma_thanh_toan int,
loai_thanh_toan varchar(255),
primary key (ma_thanh_toan)
);

create table phongtro (
ma_phong_tro int auto_increment,
ma_phong varchar(55),
ten_nguoi_thue varchar(55),
so_dien_thoai int(12),
ngay_thue datetime,
ma_thanh_toan int,
ghi_chu varchar(255),
primary key (ma_phong_tro),
FOREIGN KEY (ma_thanh_toan) REFERENCES thanhtoan (ma_thanh_toan)
);

select ma_phong_tro, ma_phong, ten_nguoi_thue, so_dien_thoai, ngay_thue, tt.loai_thanh_toan, ghi_chu from phongtro pt join thanhtoan tt on pt.ma_thanh_toan = tt.ma_thanh_toan