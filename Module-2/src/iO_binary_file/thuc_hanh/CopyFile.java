package iO_binary_file.thuc_hanh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] beffer = new byte[1024];
            int lenth;
            while ((lenth = is.read(beffer)) > 0){
                os.write(beffer, 0, lenth);
            }
        } finally {
          is.close();
          os.close();
        }
    }

    public static void main(String[] args) {
        String source = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_binary_file\\thuc_hanh\\sourceFile.csv";
        String target = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_binary_file\\thuc_hanh\\targetFile.txt";

        File sourceFile = new File(source);
        File destFile = new File(target);

        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            copyFileUsingStream(sourceFile, destFile);
            System.out.println("Copied!");
        } catch (IOException e) {
            System.err.println("U kidding me, try again.");
            System.err.println(e.getMessage());
        }finally {
            System.out.println("Done.");
        }
    }
}
