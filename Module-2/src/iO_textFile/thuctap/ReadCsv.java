package iO_textFile.thuctap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    private String facilituName;
    private String address;
    private String idDKKD;
    private String ATTP;
    private String dayF;
    private String dayE;

    public ReadCsv() {
    }

    public ReadCsv(String facilituName, String address, String idDKKD, String ATTP, String dayF, String dayE) {
        this.facilituName = facilituName;
        this.address = address;
        this.idDKKD = idDKKD;
        this.ATTP = ATTP;
        this.dayF = dayF;
        this.dayE = dayE;
    }

    public String getFacilituName() {
        return facilituName;
    }

    public void setFacilituName(String facilituName) {
        this.facilituName = facilituName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdDKKD() {
        return idDKKD;
    }

    public void setIdDKKD(String idDKKD) {
        this.idDKKD = idDKKD;
    }

    public String getATTP() {
        return ATTP;
    }

    public void setATTP(String ATTP) {
        this.ATTP = ATTP;
    }

    public String getDayF() {
        return dayF;
    }

    public void setDayF(String dayF) {
        this.dayF = dayF;
    }

    public String getDayE() {
        return dayE;
    }

    public void setDayE(String dayE) {
        this.dayE = dayE;
    }

    @Override
    public String toString() {
        return "ReadCsv{" +
                "facilituName='" + facilituName + '\'' +
                ", address='" + address + '\'' +
                ", idDKKD='" + idDKKD + '\'' +
                ", ATTP='" + ATTP + '\'' +
                ", dayF='" + dayF + '\'' +
                ", dayE='" + dayE + '\'' +
                '}';
    }

    public static List<String> parseCsvLine(String csvLine){
        List<String> result = new ArrayList<>();
        if (csvLine != null){
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++){
                result.add(splitData[i]);
            }
        }return result;
    }

    public static void printThucTap(List<String> strings){
        System.out.println(
                "[Tên cơ sở = "+strings.get(0)
                +" , Địa chỉ kinh doanh = "+strings.get(1)
                +" , Mã số ĐKKD = "+strings.get(2)
                +" , Số CN ATTP = "+strings.get(3)
                +" , Ngày cấp = "+strings.get(4)
                +" , Ngày hết hạn = "+strings.get(5)
                +"]");
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\iO_textFile\\thuctap\\ATTP-25.7.2022-TT.csv"));
            while ((line = bufferedReader.readLine()) != null){
                printThucTap(parseCsvLine(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}