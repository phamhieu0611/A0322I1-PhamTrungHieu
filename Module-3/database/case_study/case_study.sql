create  database case_study;
use  case_study;

create table vi_tri (
ma_vi_tri int primary key ,
ten_vi_tri varchar(45)
);

create table trinh_do(
ma_trinh_do int primary key , 
ten_trinh_do varchar(45)
);

create table bo_phan(
ma_bo_phan int primary key ,
ten_bo_phan varchar(45)
);

create table nhan_vien(
ma_nhan_vien int primary key,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong double not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri) on delete cascade,
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do) on delete cascade,
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan) on delete cascade
);

create table loai_khach(
ma_loai_khach int primary key,
ten_loai_khach varchar(45)
);

create table khach_hang(
ma_khach_hang int primary key,
ma_loai_khach int,
ho_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh bit(1) not null,
so_cmnd varchar(45) not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach) on delete cascade
);

create table loai_dich_vu(
ma_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45)
);

create table kieu_thue(
ma_kieu_thue int primary key,
ten_kieu_thue varchar(45)
);

create table dich_vu(
ma_dich_vu int primary key,
ten_dich_vu varchar(45) not null,
dien_tich int,
chi_phi_thue double not null,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue) on delete cascade,
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu) on delete cascade
);

create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(45) not null,
gia double not null,
don_vi varchar(10) not null,
trang_thai varchar(45)
);

create table hop_dong(
ma_hop_dong int primary key,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key (ma_Nhan_vien) references nhan_vien(ma_nhan_vien) on delete cascade,
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang)on delete cascade,
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu) on delete cascade
);

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int not null,
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong) on delete cascade,
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem) on delete cascade
);

-- answer1 
insert into vi_tri(ma_vi_tri, ten_vi_tri)
values
(1, 'Quản lý'),
(2, 'Nhân viên');

insert into trinh_do(ma_trinh_do, ten_trinh_do)
values
(1, 'Trung Cấp'),
(2, 'Cao Đẳng'),
(3, 'Đại Học'),
(4, 'Sau Đại Học');

insert into bo_phan(ma_bo_phan, ten_bo_phan)
values
(1, 'Sale-Marketing'),
(2, 'Hành chính'),
(3, 'Phục vụ'),
(4, 'Quản lý');

insert into nhan_vien(ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
values
(1, 'Nguyễn Văn An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng',	1, 3, 1),
(2, 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
(3, 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
(4, 'Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
(5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
(6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
(7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
(8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
(9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
(10, 'Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);

insert into loai_khach(ma_loai_khach, ten_loai_khach)
values
(1, 'Diamond'),
(2, 'Platinium'),
(3, 'Gold'),
(4, 'Silver'),
(5, 'Member');

insert into khach_hang(ma_khach_hang, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach)
values
(1, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
(2, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
(3, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
(4, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
(5, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
(6, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
(7, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
(8, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
(9, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
(10, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);

insert into kieu_thue(ma_kieu_thue, ten_kieu_thue)
values
(1, 'year'),
(2, 'month'),
(3, 'day'),
(4, 'hour');

insert into loai_dich_vu(ma_loai_dich_vu, ten_loai_dich_vu)
values
(1, 'Villa'),
(2, 'House'),
(3, 'Room');

insert into dich_vu(ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu)
values
(1, 'Villa Beach Front', 25000, 10000000, 10, 'vip', 'Có hồ bơi', 500, 4, 3, 1),
(2, 'House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, 3, 2, 2),
(3, 'Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', null, null, 4, 3),
(4, 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, 3, 1),
(5, 'House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null, 2, 3, 2),
(6, 'Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, 4, 3); 

insert into dich_vu_di_kem(ma_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai)
values
(1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
(2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
(3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
(4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');

insert into hop_dong(ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values
(1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18','100000',7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,3,4,3),
(10,'2021-04-12','2021-04-14',0,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,10,1);

insert into hop_dong(ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values
(1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18','100000',7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,3,4,3),
(10,'2021-04-12','2021-04-14',0,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,10,1);

insert into hop_dong_chi_tiet(ma_hop_dong_chi_tiet,so_luong,ma_hop_dong,ma_dich_vu_di_kem)
values
(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);

-- answer2
select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'K%' or ho_ten like 'T%') and char_length(ho_ten) <= 15; 

-- answer3
select * from khach_hang
where (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị') and year(curdate()) - year(ngay_sinh) between 18 and 50;

-- answer4
select kh.ma_khach_hang, kh.ho_ten, count(ifnull(hd.ma_khach_hang, 0)) as so_lan_dat_phong 
from khach_hang kh 
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where lk.ten_loai_khach = 'Diamond' group by kh.ma_khach_hang order by so_lan_dat_phong;

-- answer5
create view tong_tien as
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
(ifnull(dv.chi_phi_thue, 0)+sum(ifnull(hdct.so_luong, 0)*ifnull(dvdk.gia, 0))) as tong_tien
from khach_hang kh 
left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by kh.ma_khach_hang;
select * from tong_tien;

-- answer6
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
where hd.ma_dich_vu not in(
select hd.ma_dich_vu
from hop_dong hd
where (year(hd.ngay_lam_hop_dong) = 2021) and month(hd.ngay_lam_hop_dong) in (1, 2, 3))
group by dv.dien_tich;

-- answer7
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
where hd.ma_dich_vu in(
select hd.ma_dich_vu
from hop_dong hd
where (year(hd.ngay_lam_hop_dong) = 2020))
and hd.ma_dich_vu not in (
select hd.ma_dich_vu
from hop_dong hd
where (year(hd.ngay_lam_hop_dong) = 2021))
group by dv.dien_tich;

-- answer8
select distinct ho_ten from khach_hang;

select ho_ten from khach_hang group by ho_ten;

select ho_ten from khach_hang union select ho_ten from khach_hang;

-- answer9
select month(ngay_lam_hop_dong) as thang, count(ma_khach_hang) as so_luong_dat_phong from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by thang order by thang;

-- answer10
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc,
ifnull(sum(hdct.so_luong), 0) as so_luong
from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by hd.ma_hop_dong;

-- answer11
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where kh.ma_loai_khach = 1 and (kh.dia_chi like '%Vinh' or kh.dia_chi like '%Quảng Ngãi');

-- answer12
select hd.ma_hop_dong, nv.ho_ten as ten_nhan_vien, kh.ho_ten as ten_khach_hang, kh.so_dien_thoai, dv.ma_dich_vu, dv.ten_dich_vu, sum(ifnull(hdct.so_luong, 0)) as so_luong_dich_vu_di_kem, hd.tien_dat_coc
from hop_dong hd
left join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
left join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
where (year(hd.ngay_lam_hop_dong)) = 2020 and (month(hd.ngay_lam_hop_dong) in (10, 11, 12))
and hd.ma_hop_dong not in(
select hd.ma_hop_dong
from hop_dong hd
where year(hd.ngay_lam_hop_dong) =2021 and (month(hd.ngay_lam_hop_dong) between 1 and 6))
group by hd.ma_hop_dong;

-- answer13
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_dich_vu_di_kem
from hop_dong_chi_tiet hdct
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem 
having so_dich_vu_di_kem >= all(
select sum(hdct.so_luong)
from hop_dong_chi_tiet hdct
group by hdct.so_luong);

-- answer14
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as lan_su_dung
from hop_dong hd
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ten_dich_vu_di_kem
having lan_su_dung = 1
order by hd.ma_hop_dong;

-- answer15
select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
from hop_dong hd
join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
group by hd.ma_nhan_vien
having count(hd.ma_nhan_vien) <= 3;

-- answer16
select * from nhan_vien;
delete from nhan_vien nv
where nv.ma_nhan_vien not in (
select ma_nhan_vien
from hop_dong hd
where year(hd.ngay_lam_hop_dong) between 2019 and 2021
group by nv.ma_nhan_vien);

-- answer17
update khach_hang
set ma_loai_khach = 1
where ma_loai_khach in (select mlk.ma_loai_khach from(
select ma_khach_hang, ten_loai_khach, ma_loai_khach,
sum(ifnull(tong_tien, 0)) as tong_tien_nam_2021
from tong_tien
where year(ngay_lam_hop_dong) = '2021'
and ten_loai_khach = 'Platium'
group by ma_khach_hang
having tong_tien_nam_2021 > 1000000) as	mlk);

-- answer18
delete from khach_hang
where ma_khach_hang in (
select hd.ma_khach_hang from (
select hd.ma_khach_hang
from hop_dong hd 
join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
where year(hd.ngay_lam_hop_dong) < 2021 ) as mhd );

select * from hop_dong;

-- answer19
select dvdk.ten_dich_vu_di_kem, dvdk.gia, case sum(hdct.so_luong)>10 when true  then dvdk.gia * 2 else dvdk.gia end as gia_sau_khi_thay_doi
from hop_dong hd
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong) = 2020 
group by dvdk.ma_dich_vu_di_kem 
having sum(hdct.so_luong) >=10;

-- answer20
select nv.ma_nhan_vien as id, nv.ho_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi 
from nhan_vien nv
union
select kh.ma_khach_hang as id, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh,  kh.dia_chi from khach_hang kh
order by id;

-- answe21
insert into nhan_vien(ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan)
values (12,'Nguyen Van B','2000-11-24','184659256','8000000','0965959784','nvB@gmail.com','15 Hải Châu, Đà Nẵng',1, 1, 2);
insert into hop_dong(ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values
(14,'2019-12-12','2020-12-09',0,12,1,3);

create view v_nhan_vien as select nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.luong, nv.so_dien_thoai, nv.email, nv.dia_chi, hd.ngay_lam_hop_dong
from nhan_vien nv
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
where hd.ngay_lam_hop_dong = '2019-12-12' and nv.dia_chi like '%Hải Châu%';

select * from v_nhan_vien;

-- answer22
update v_nhan_vien
set dia_chi = 'Liên Chiểu'
where dia_chi like '%Hải Châu%';

create view v_nhan_vien_sau_khi_sua as select nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.luong, nv.so_dien_thoai, nv.email, nv.dia_chi, hd.ngay_lam_hop_dong
from nhan_vien nv
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
where hd.ngay_lam_hop_dong = '2019-12-12' and nv.dia_chi like '%Liên Chiểu%';

select * from v_nhan_vien_sau_khi_sua;

-- answer23
delimiter //
create procedure sp_xoa_khach_hang (in ma_khach_hang1 int)
begin
delete from khach_hang
where ma_khach_hang = ma_khach_hang1;
end //
delimiter ;

call sp_xoa_khach_hang (10);

select * from khach_hang;

-- answer24
delimiter //
create procedure sp_them_moi_hop_dong (in ma_hop_dong1 int, in ngay_lam_hop_dong1 datetime, in ngay_ket_thuc1 datetime, 
in tien_dat_coc1 double, in ma_nhan_vien1 int, in ma_khach_hang1 int, in ma_dich_vu1 int)
begin
declare count_ma_hop_dong int default '0';
select count(*) into count_ma_hop_dong from hop_dong where ma_hop_dong = ma_hop_dong1;
if (count_ma_hop_dong = 0) then 
insert into hop_dong(ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values
(ma_hop_dong1,ngay_lam_hop_dong1,ngay_ket_thuc1,tien_dat_coc1,ma_nhan_vien1,ma_khach_hang1,ma_dich_vu1);
end if; 
end //
delimiter ;

call sp_them_moi_hop_dong(20,'2022-08-08','2022-12-12',0,2,2,1);

select * from hop_dong;

-- answer25
delimiter //
create trigger tr_xoa_hop_dong
after delete on hop_dong for each row
begin 
	set @c = (select count(*) from hop_dong);
    signal sqlstate '01000' set message_text = @c;
end //
delimiter ;

delete from hop_dong where ma_hop_dong = 6;

-- answer26
DELIMITER //
CREATE trigger tr_cap_nhat_hop_dong
after UPDATE on hop_dong FOR EACH ROW
BEGIN
if new.ngay_lam_hop_dong + 2 > new.ngay_ket_thuc then signal SQLSTATE '02000' set MESSAGE_TEXT = 'Invaild start date';
end if;
END
// DELIMITER ;

-- answer27
SET GLOBAL log_bin_trust_function_creators = 1;


DELIMITER //
create FUNCTION func_dem_dich_vu()
RETURNS  int
BEGIN
DECLARE res int;
select count(*) INTO res from (select sum(chi_phi_thue) t from dich_vu
join hop_dong using(ma_dich_vu)
group by ma_dich_vu
having t > 2000000) as tmp;
return res;
END
// DELIMITER ;
select func_dem_dich_vu();


DELIMITER //
CREATE FUNCTION func_tinh_thoi_gian_hop_dong(p_ma_khach_hang int)
RETURNS int
begin
DECLARE res int;
select max(tmp.t) into res from (select datediff(ngay_ket_thuc, ngay_lam_hop_dong) t from hop_dong
WHERE ma_khach_hang= p_ma_khach_hang) as tmp;
RETURN res;
end
// DELIMITER ;
select func_tinh_thoi_gian_hop_dong(5);

-- answer28
DELIMITER //
CREATE PROCEDURE sp_xoa_dich_vu_va_hd_room()
BEGIN
SET @myvar := (SELECT GROUP_CONCAT(ma_hop_dong SEPARATOR ',')  from dich_vu
JOIN loai_dich_vu using(ma_loai_dich_vu)
JOIN hop_dong using(ma_dich_vu)
WHERE ten_loai_dich_vu = 'Room' and  year(ngay_lam_hop_dong) BETWEEN 2015 and 2020);

DELETE FROM hop_dong_chi_tiet  WHERE FIND_IN_SET(ma_hop_dong,@myvar);
DELETE FROM hop_dong  WHERE FIND_IN_SET(ma_hop_dong,@myvar);
DELETE from dich_vu
WHERE ma_dich_vu in ( SELECT DISTINCT
			ma_dich_vu
		FROM
			hop_dong
		WHERE
			 FIND_IN_SET(ma_hop_dong,@myvar));
END
// DELIMITER ;
call sp_xoa_dich_vu_va_hd_room();