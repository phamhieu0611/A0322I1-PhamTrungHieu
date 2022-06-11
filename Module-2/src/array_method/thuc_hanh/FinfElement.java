package array_method.thuc_hanh;

import java.util.Scanner;

public class FinfElement {
    public static void main(String[] args) {
        String[] students = {"Hiếu", "Híu", "Howard", "MR. Wayne", "Great Owl", "loser"};
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập vào tên sinh viên: ");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++){
            if (students[i].equals(input_name)){
                System.out.println("Thứ tự của sinh viên "+input_name+" trong danh sách là: "+(i+1));
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("Không tìm thấy sinh viên "+input_name+" trong danh sách.");
        }
    }
}
