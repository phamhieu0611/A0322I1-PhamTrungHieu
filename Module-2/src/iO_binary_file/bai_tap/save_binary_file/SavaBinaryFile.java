package iO_binary_file.bai_tap.save_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SavaBinaryFile {
    public static void main(String[] args) {
        try {
            do {
                Scanner scanner = new Scanner(System.in);
                List<Product> products = readFile("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_binary_file\\bai_tap\\save_binary_file\\product.txt");
                System.out.println("Menu action:");
                System.out.println("1 to add.");
                System.out.println("2 to display list product.");
                System.out.println("3 to Exit.");
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        System.out.print("Input id product: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Input name product: ");
                        String name = scanner.nextLine();
                        System.out.print("Input brand product: ");
                        String brand = scanner.nextLine();
                        System.out.print("Input description product: ");
                        String desc = scanner.nextLine();
                        System.out.print("Input price product: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        products.add(new Product(id, name, brand, desc, price));
                        System.out.println("Write to file");
                        writeToFile("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_binary_file\\bai_tap\\save_binary_file\\product.txt", products);
                        break;
                    case 2:
                        listProduct(products);
                        break;
                    case 3:
                        System.exit(0);
                }
            }while (true);
        }catch (Exception e){
            System.err.println("Exception "+e.getMessage());
        }
    }

    public static void writeToFile(String filePath, List<Product> products){
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            fos.close();
            oos.close();
        } catch (Exception e){
            System.err.println("Exception "+e.getMessage());
        }
    }

    public static List<Product> readFile(String FilePath){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FilePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            System.err.println("Exception "+e.getMessage());
        }return products;
    }

    public static void listProduct(List<Product> list){
        System.out.println("List Product: ");
        for (Product eProduct : list){
            System.out.println(eProduct);
        }
    }
}