package fake_final_exam2.service.serviceImpl;

import fake_final_exam.controller.Maincontroller;
import fake_final_exam2.models.GiangVien;
import fake_final_exam2.service.Person;
import fake_final_exam2.utils.ReadFile;
import fake_final_exam2.utils.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiangVienImpl implements Person {
    private static final String GIANGVIEN_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam2\\data\\giangVien.csv";
    private static Scanner scanner = new Scanner(System.in);
    private static List<GiangVien> giangVienList = new ArrayList<>();

    @Override
    public void add() {
        try {
            System.out.println("nhap vao ten: ");
            String name = scanner.nextLine();
            System.out.println("nhap vao ngay sinh: ");
            String date = scanner.nextLine();
            System.out.println("nhap vao gioi tinh: ");
            String gender = scanner.nextLine();
            System.out.println("nhap vao chuyen mon: ");
            String chuyenMon = scanner.nextLine();
            GiangVien giangVien = new GiangVien(name, date, gender, chuyenMon);
            WriteFile.addGiangVien(giangVien);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void display() {
        giangVienList = ReadFile.readGiangVienFile(GIANGVIEN_CSV);
        try {
            if (giangVienList.size() != 0){
                for (GiangVien giangVien: giangVienList){
                    System.out.println(giangVien.toString());
                }
            }if (giangVienList.size() == 0){
                System.out.println("The list Empty.");
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void find() {
        giangVienList = ReadFile.readGiangVienFile(GIANGVIEN_CSV);
        try {
            System.out.println("Nhap vao ten muon tim kiem: ");
            String ten = scanner.nextLine();
            if (giangVienList.size() != 0){
                for (GiangVien giangVien: giangVienList){
                    if (ten.equalsIgnoreCase(giangVien.getName())){
                        System.out.println(giangVien.toString());
                    }
                }
            }if (giangVienList.size() == 0){
                System.out.println("The list Empty.");
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void delete() {
        try {
            display();
            System.out.println("Nhap vao ten nguoi muon xoa: ");
            String bienSo = scanner.nextLine();
            for (GiangVien giangVien: giangVienList){
                if (bienSo.equalsIgnoreCase(giangVien.getName())){
                    int select = 0;
                    System.out.println("Ban co chac chan muon xoa "+giangVien.toString()+" hay khong?");
                    System.out.println("1. co");
                    System.out.println("2. khong");
                    select = Integer.parseInt(scanner.nextLine());
                    switch (select){
                        case 1:
                            giangVienList.remove(giangVien);
                            WriteFile.writeAfterDeleteGiangVien(giangVienList);
                            System.out.println("Done!");
                            break;
                        case 2:
                            Maincontroller.mainController();
                            break;
                    }
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }
}
