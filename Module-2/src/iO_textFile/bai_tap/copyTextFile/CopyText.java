package iO_textFile.bai_tap.copyTextFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyText {
    public List<String> readFile(String filePath){
        List<String> string = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null){
                string.add(line);
            }
        }  catch (Exception e) {
            System.err.println("Exception "+e.getMessage());
        } finally {
            System.out.println("Raed file: OK!");
        } return string;
    }

    public void writeFile(String filePatch, List<String> string){
        try {
            FileWriter fileWriter = new FileWriter(filePatch, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String value : string){
                bufferedWriter.write(value);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Copy file: OK!");
        }
    }

    public void copyByte(String filePatch, String filePatchTarget){
        writeFile(filePatch, readFile(filePatchTarget));
    }

    public static void main(String[] args) {
        CopyText copyText = new CopyText();
        copyText.readFile("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_textFile\\bai_tap\\copyTextFile\\source.txt");
        copyText.copyByte("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_textFile\\bai_tap\\copyTextFile\\target.txt", "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_textFile\\bai_tap\\copyTextFile\\source.txt");
    }
}
