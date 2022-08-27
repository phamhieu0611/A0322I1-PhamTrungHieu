CREATE DATABASE demo;
USE demo;
CREATE TABLE Products(
	Id INT PRIMARY KEY NOT NULL,
	productCode INT,
	productName VARCHAR(45),
	productPrice FLOAT,
	productAmount INT,
	productDescription VARCHAR(45),
	productStatus BIT
);
INSERT INTO Products
VALUE (1, 895,'SONY', 15, 100, 'antique', 1),
	  (2, 402, 'APPLE', 20, 50, 'up-to-date',1),
      (3, 354, 'SAMSUNGG', 5,13, 'cheap',0),
      (4, 657, 'ASUS', 15, 7, 'synup', 1),
      (5, 951, 'DELL', 17, 9, 'fullC', 0);
SELECT * FROM Products;

CREATE UNIQUE INDEX Products_index ON Products(ProductCode);

CREATE UNIQUE INDEX Products_CompositeIndex ON Products(ProductCode);

EXPLAIN SELECT * FROM Products WHERE productCode = '402';

-- before 5 row; after 1 row

CREATE VIEW products_view AS
SELECT productCode, productName, productPrice, productStatus
FROM Products;

SELECT * FROM products_view;

update products_view
set productPrice = 200
where productName = 'APPLE';

DROP VIEW products_view;
