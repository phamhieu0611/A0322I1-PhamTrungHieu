CREATE DATABASE QuanLyBanHang;
USE QuanLyBanHang;
CREATE TABLE Customer(
	CUSTOMER_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    CUSTOMER_NAME VARCHAR(50),
    CUSTOMER_AGE INT
);

CREATE TABLE `Order`(
	ORDER_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    CUSTOMER_ID INT,
    ORDER_DATE DATE,
    ORDER_TOTAL_PRICE FLOAT,
    FOREIGN KEY (CUSTOMER_ID) REFERENCES Customer (CUSTOMER_ID)
);

CREATE TABLE Product(
    PRODUCT_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    PRODUCT_Name VARCHAR(50),
    PRODUCT_Price FLOAT
);

CREATE TABLE OrderDetail(
	ORDER_ID INT,
    PRODUCT_ID INT,
    odQTY VARCHAR(100),
    PRIMARY KEY (ORDER_ID, PRODUCT_ID),
    FOREIGN KEY (ORDER_ID) REFERENCES `Order` (ORDER_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES Product (PRODUCT_ID)
);

INSERT INTO Customer
	(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_AGE)
VALUE (1,'Minh Quan', 10),
	  (2, 'Ngoc Oanh', 20),
      (3, 'Hong Ha', 50);
	SELECT *FROM
    Customer;
INSERT INTO `Order` (ORDER_ID, CUSTOMER_ID, ORDER_DATE, ORDER_TOTAL_PRICE)
VALUE (1, 1, '2006-03-21', Null),
	  (2, 2, '2006-03-23', Null), 
      (3, 1, '2006-03-16', Null);
SELECT * FROM
    `Order`;
INSERT INTO Product (PRODUCT_ID, PRODUCT_Name, PRODUCT_Price)
VALUE (1,'May Giat', 3),
	  (2, 'Tu Lanh', 5),
      (3, 'Dieu Hoa', 7),
      (4, 'Quat', 1),
      (5, 'Bep Dien', 2);
SELECT *FROM
    Product;
INSERT INTO OrderDetail (ORDER_ID, PRODUCT_ID, odQTY)
VALUE (1, 1, 3),
	  (1, 3, 7),
      (1, 4, 2),
      (2, 1, 1),
      (3, 1, 8),
      (2, 5, 4),
      (2, 3, 3);
      SELECT * FROM OrderDetail;
      
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT ORDER_ID, ORDER_DATE, ORDER_TOTAL_PRICE FROM `Order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT C.CUSTOMER_NAME, P.PRODUCT_Name  
FROM Customer C JOIN `Order` O ON C.CUSTOMER_ID = O.CUSTOMER_ID 
				JOIN OrderDetail Od ON O.ORDER_ID = Od.ORDER_ID
                JOIN Product P ON Od.PRODUCT_ID = P.PRODUCT_ID;
                
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào

SELECT C.CUSTOMER_NAME
FROM Customer C 
WHERE CUSTOMER_ID NOT IN ( 
SELECT C.CUSTOMER_ID 
FROM Customer c JOIN `Order` O ON C.CUSTOMER_ID = O.CUSTOMER_ID);
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice)
SELECT O.ORDER_ID, O.ORDER_DATE, Sum(IFNULL(Od.odQTY,0) * IFNULL(P.PRODUCT_Price,0)) AS totalPrice
FROM `Order` O 
join OrderDetail Od on O.ORDER_ID= Od.ORDER_ID
join Product P on Od.PRODUCT_ID = P.PRODUCT_ID
group by O.ORDER_ID;