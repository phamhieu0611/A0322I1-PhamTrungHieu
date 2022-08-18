CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;
CREATE TABLE Class(
	ClassID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME NOT NULL,
    Status BIT
);
CREATE TABLE Student(
	StudentID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    StudentName VARCHAR(30) NOT NULL,
    Address VARCHAR(50),
    Phone VARCHAR(20),
    Status BIT,
    ClassID INT NOT NULL,
    FOREIGN KEY (ClassID) REFERENCES Class (ClassID) 
);
CREATE TABLE `Subject`(
	SubID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    SubName VARCHAR(30) NOT NULL,
    Credit TINYINT NOT NULL DEFAULT 1 CHECK (Credit >=1),
    Status BIT DEFAULT 1 
);
CREATE TABLE Mark(
	MarkID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    SubID INT NOT NULL UNIQUE KEY,
    StudentID INT NOT NUll UNIQUE KEY,   
    Mark FLOAT DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    FOREIGN KEY (SubID) REFERENCES Subject (SubID),
    FOREIGN KEY (StudentID) REFERENCES Student (StudentID)
);
INSERT INTO Class
VALUE (1,'A1','2008-12-20',1);
SELECT*FROM Class;
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
       
SELECT*FROM Student;
SELECT *
FROM Student
WHERE Status = true;
SELECT*FROM Subject WHERE (Credit<10);

-- Sử dụng câu lệnh Join và where để hiển thị danh sách học viên lớp A1
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

-- Hiển thị điểm môn CF của các học viên
SELECT S.StudentID, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentID = M.StudentID join Subject Sub on M.SubID = Sub.SubID
WHERE (Sub.SubName = 'CF');

USE QuanLySinhVien;

SELECT Address, COUNT(StudentId) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 15;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);

SELECT * FROM `Subject`
WHERE Credit = (SELECT MAX(Credit) FROM `Subject`);

SELECT s.subID, s.subName, MAX(m.Mark) 
FROM `Subject` s JOIN Mark m on s.SubID = m.SubID;

SELECT s.StudentID, s.StudentName, s.Address, s.Phone, AVG(m.Mark) AS dtb
FROM Student s JOIN Mark m ON s.StudentID = m.StudentID
GROUP BY s.StudentID
ORDER BY dtb, s.StudentName DESC;  