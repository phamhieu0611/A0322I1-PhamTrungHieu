package iO_binary_file.bai_tap.optional;

import java.io.*;
import java.util.ArrayList;

public class copyLargeFile {
    public static void main(String[] args) {
        copyLargeFile copyFile=new copyLargeFile();
        copyFile.copyFile("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_binary_file\\bai_tap\\optional\\fileSorce.tst","C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_binary_file\\bai_tap\\optional\\fileTarget");
    }

    private ArrayList<Character> readFileText(String filePath) {
        ArrayList<Character> arrayList=new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            InputStream is =new FileInputStream(file);
            int line;
            while ((line = is.read()) != -1) {
                arrayList.add((char) line);
            }
            is.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return arrayList;
    }

    private void writeFile(String filePath, ArrayList<Character> arrayList){
        try {
            File file = new File(filePath);
            OutputStream outputStream=new FileOutputStream(file);
            int count = 0;
            for (Character character:arrayList)
            {
                outputStream.write(character);
                count++;
            }
            outputStream.close();
            System.out.println("Số byte trong tệp là: "+count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String filePath,String filePathTarget)
    {
        writeFile(filePathTarget,readFileText(filePath));
    }
}

