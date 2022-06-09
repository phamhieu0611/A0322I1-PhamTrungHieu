package introduction_to_java.thuc_hanh;

import java.util.Locale;
import java.util.Scanner;


public class BMI {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);
        double weight, height, bmi;
        System.out.print("Nhập vào cân nặng của đối tượng (Kilogram): ");
        weight = input.nextDouble();
        System.out.print("Nhập vào chiều cao của đối tượng (Mét): ");
        height = input.nextDouble();
        bmi = weight / Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Tình trạng\n");

        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Nhẹ cân");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Bình thường");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Quá cân");
        else
            System.out.printf("%-20.2f%s", bmi, "Béo phì");
    }
}
