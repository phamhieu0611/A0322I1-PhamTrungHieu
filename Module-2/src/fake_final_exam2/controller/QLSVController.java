package fake_final_exam2.controller;

import fake_final_exam2.service.serviceImpl.GiangVienImpl;
import fake_final_exam2.service.serviceImpl.HocSinhImpl;

import java.util.Scanner;

public class QLSVController {
    private static Scanner scanner = new Scanner(System.in);
    private static HocSinhImpl hocSinh = new HocSinhImpl();
    private static GiangVienImpl giangVien = new GiangVienImpl();

    public static void QLSVController(){
        while (true){
            try{
                int select = 0;
                System.out.println("--------------------------Menu--------------------------");
                System.out.println("1. Them moi giang vien hoac hoc sinh.");
                System.out.println("2. Xoa giang vien hoac hoc sinh.");
                System.out.println("3. Xem danh sach giang vien hoac hoc sinh.");
                System.out.println("4. Tim gang vien hoac hoc sinh.");
                System.out.println("5. Exit.");
                System.out.print("Enter your choice: ");
                select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        int choose = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. Them giang vien.");
                        System.out.println("2. Them hoc sinh.");
                        System.out.println("3. back to menu.");
                        System.out.print("Enter your choice: ");
                        choose = Integer.parseInt(scanner.nextLine());
                        switch (choose){
                            case 1:
                                hocSinh.add();
                                break;
                            case 2:
                                giangVien.add();
                                break;
                            case 3:
                                QLSVController();
                                break;
                        }
                        break;
                    case 2:
                        int choice = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. Xoa giang vien.");
                        System.out.println("2. Xoa hoc sinh.");
                        System.out.println("3. Display menu.");
                        System.out.print("Enter your choice: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice){
                            case 1:
                                hocSinh.delete();
                                break;
                            case 2:
                                giangVien.delete();
                                break;
                            case 3:
                                QLSVController();
                                break;
                        }
                        break;
                    case 3:
                        int nhap = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. Hien thi hoc sinh.");
                        System.out.println("2. Hien thi giang vien.");
                        System.out.println("3. back to menu.");
                        System.out.print("Enter your choice: ");
                        nhap = Integer.parseInt(scanner.nextLine());
                        switch (nhap){
                            case 1:
                                hocSinh.display();
                                break;
                            case 2:
                                giangVien.display();
                                break;
                            case 3:
                                QLSVController();
                                break;
                        }
                        break;
                    case 4:
                        int input = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. Tim hoc sinh.");
                        System.out.println("2. Tim giang vien.");
                        System.out.println("3. Display menu.");
                        System.out.print("Enter your choice: ");
                        input = Integer.parseInt(scanner.nextLine());
                        switch (input){
                            case 1:
                                hocSinh.find();
                                break;
                            case 2:
                                hocSinh.find();
                                break;
                            case 3:
                                QLSVController();
                                break;
                        }
                        break;
                    case 5:
                        System.exit(0);
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static void main(String[] args) {
        QLSVController();
    }
}
