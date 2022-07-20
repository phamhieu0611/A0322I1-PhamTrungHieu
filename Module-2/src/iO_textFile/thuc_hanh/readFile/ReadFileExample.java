package iO_textFile.thuc_hanh.readFile;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readfileExample(String filePath){
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int sum = 0;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            reader.close();
            System.out.println("sum = "+sum);
        }catch (Exception e){
            System.err.println("File not found, check and try again!");
        }finally {
            System.out.println("Finally, Done!");
        }
    }

    public static void main(String[] args) {
        System.out.print("Input src file: ");
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readfileExample(src);
    }
}
