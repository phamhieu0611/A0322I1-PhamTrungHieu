package fake_final_exam2.service.serviceImpl;

import fake_final_exam.controller.Maincontroller;
import fake_final_exam2.models.HocSinh;
import fake_final_exam2.service.Person;
import fake_final_exam2.utils.ReadFile;
import fake_final_exam2.utils.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HocSinhImpl implements Person {
    private static final String HOCSINH_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam2\\data\\hocSinh.csv";
    private static Scanner scanner = new Scanner(System.in);
    private static List<HocSinh> listHocSinh = new ArrayList<>();

    @Override
    public void add() {
        try {
            System.out.println("nhap vao ten: ");
            String name = scanner.nextLine();
            System.out.println("nhap vao ngay sinh: ");
            String date = scanner.nextLine();
            System.out.println("nhap vao gioi tinh: ");
            String gender = scanner.nextLine();
            System.out.println("nhap vao lop hoc: ");
            String lop = scanner.nextLine();
            System.out.println("nhap vao diem: ");
            String diem = scanner.nextLine();
            HocSinh hocSinh = new HocSinh(name, date, gender, lop, diem);
            listHocSinh.add(hocSinh);
            WriteFile.ghiFileHocSinh(listHocSinh);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void display() {
        listHocSinh = ReadFile.readHocSinhFile(HOCSINH_CSV);
        try {
            if (listHocSinh.size() != 0){
                for (HocSinh hocSinh: listHocSinh){
                    System.out.println(hocSinh.toString());
                }
            }if (listHocSinh.size() == 0){
                System.out.println("The list Empty.");
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void find() {
        listHocSinh = ReadFile.readHocSinhFile(HOCSINH_CSV);
        try {
            System.out.println("Nhap vao ten muon tim kiem: ");
            String ten = scanner.nextLine();
            if (listHocSinh.size() != 0){
                for (HocSinh hocSinh: listHocSinh){
                    if (ten.equalsIgnoreCase(hocSinh.getName())){
                        System.out.println(hocSinh.toString());
                    }
                }
            }if (listHocSinh.size() == 0){
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
            String ten = scanner.nextLine();
            for (HocSinh hocSinh: listHocSinh){
                if (ten.equalsIgnoreCase(hocSinh.getName())){
                    int select = 0;
                    System.out.println("Ban co chac chan muon xoa "+hocSinh.toString()+" hay khong?");
                    System.out.println("1. co");
                    System.out.println("2. khong");
                    select = Integer.parseInt(scanner.nextLine());
                    switch (select){
                        case 1:
                            listHocSinh.remove(hocSinh);
                            WriteFile.writeAfterDeleteHocSinh(listHocSinh);
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

    @Override
    public void edit() {
        try {
            display();
            System.out.println("Nhap vao ten nguoi muon thay doi: ");
            String bienSo = scanner.nextLine();
            int count = 0;
            for (HocSinh hocSinh: listHocSinh){
                if (bienSo.equalsIgnoreCase(hocSinh.getName())){
                    System.out.println("nhap vao ten moi: ");
                    String nameMoi = scanner.nextLine();
                    System.out.println("nhap vao ngay sinh moi: ");
                    String dateMoi = scanner.nextLine();
                    System.out.println("nhap vao gioi tinh moi: ");
                    String genderMoi = scanner.nextLine();
                    System.out.println("nhap vao lop hoc moi: ");
                    String lopMoi = scanner.nextLine();
                    System.out.println("nhap vao diem moi: ");
                    String diemMoi = scanner.nextLine();
                    HocSinh hocSinh1 = new HocSinh(nameMoi, dateMoi, genderMoi, lopMoi, diemMoi);
                    listHocSinh.set(count, hocSinh1);
                    WriteFile.writeAfterDeleteHocSinh(listHocSinh);
                    System.out.println("Done!");
                    break;
                }
                count++;
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }
}
