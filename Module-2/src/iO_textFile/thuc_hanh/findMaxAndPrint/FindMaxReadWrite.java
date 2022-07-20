package iO_textFile.thuc_hanh.findMaxAndPrint;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindMaxReadWrite {
    public List<Integer> readFile (String filePath){
        List<Integer> number = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s = "";
            while ((s = reader.readLine())!=null){
                number.add(Integer.parseInt(s));
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("File not found, try again!");
        }finally {
            System.out.println("OK!");
        }return number;
    }

    public static int findMax(List<Integer> number){
        int max = number.get(0);
            for (int i = 0; i < number.size(); i++){
                if (max < number.get(i)){
                    max = number.get(i);
                }
            }return max;
    }


    public void writeFile(String filePatch, int max){
        try {
            FileWriter fileWriter = new FileWriter(filePatch, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Max value is: "+max+"\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("OK!");
        }
    }

    public void readfileExample(String filePath){
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }catch (Exception e){
            System.err.println("File not found, check and try again!");
        }finally {
            System.out.println("Finally, Done!");
        }
    }

    public static void main(String[] args) {
        FindMaxReadWrite readWrite = new FindMaxReadWrite();
        System.out.println("Open the file have Numbers!");
        List<Integer> number = readWrite.readFile("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_textFile\\thuc_hanh\\findMaxAndPrint\\number.txt");
        int maxValue = findMax(number);
        System.out.println("Write in new file the max value of numbers in previous file. ");
        readWrite.writeFile("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_textFile\\thuc_hanh\\findMaxAndPrint\\result.txt", maxValue);
        System.out.println("Read sesult file! (Optional)");
        readWrite.readfileExample("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_textFile\\thuc_hanh\\findMaxAndPrint\\result.txt");
    }
}
