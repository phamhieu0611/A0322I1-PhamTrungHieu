CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;
CREATE TABLE Class (
    ClassID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME NOT NULL,
    Status BIT
);
CREATE TABLE Student (
    StudentID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    StudentName VARCHAR(30) NOT NULL,
    Address VARCHAR(50),
    Phone VARCHAR(20),
    Status BIT,
    ClassID INT NOT NULL,
    FOREIGN KEY (ClassID)
        REFERENCES Class (ClassID)
);
CREATE TABLE Subject (
    SubID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    SubName VARCHAR(30) NOT NULL,
    Credit TINYINT NOT NULL DEFAULT 1 CHECK (Credit >= 1),
    Status BIT DEFAULT 1
);
CREATE TABLE Mark (
    MarkID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    SubID INT NOT NULL UNIQUE KEY,
    StudentID INT NOT NULL UNIQUE KEY,
    Mark FLOAT DEFAULT 0 CHECK (Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    FOREIGN KEY (SubID)
        REFERENCES Subject (SubID),
    FOREIGN KEY (StudentID)
        REFERENCES Student (StudentID)
);
INSERT INTO Class
VALUE (1,'A1','2008-12-20',1);
SELECT 
    *
FROM
    Class;
INSERT INTO Class
VALUE (2,'A2','2008-12-20',1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassID)
VALUE ('Hung', 'Ha Noi', '0912113113', 1, 1); 
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO Subject 
VALUE (1,'CF',5,1),
	  (2,'C',6,1),
      (3, 'HDJ', 5, 1),
	  (4, 'RDBMS', 10, 1);
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (2, 2, 10, 2),
       (3, 3, 12, 1);
       
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT 
    *
FROM
    Student
WHERE
    StudentName LIKE 'h%';
    -- tinh lớp học có thời gian bắt đầu vào tháng 12.
	SELECT * FROM Class WHERE StartDate LIKE '%12%';
    
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
	SELECT * FROM Subject WHERE ( Credit BETWEEN 3 AND 5);
    
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2
	SELECT*FROM Student;
    UPDATE Student
    SET ClassID = 2
    WHERE (StudentName LIKE 'Hung');
     
/* Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp 
	theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần. */  
    SELECT * FROM Mark;
    SELECT s.StudentName, sub.SubName,m.mark
	FROM Student s join Mark m 
	ON s.StudentID = m.StudentID
	JOIN `subject` sub 
	ON sub.SubID = m.SubID
	ORDER BY Mark desc, s.StudentName;