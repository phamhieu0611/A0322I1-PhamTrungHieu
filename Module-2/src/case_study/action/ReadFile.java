package case_study.action;

import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.models.person.Customer;
import case_study.models.person.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadFile {
    public static List<Employee> readEmployeeFile(String filePath){
        List<Employee> employees = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Employee employee;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                int idCard = Integer.parseInt(temp[1]);
                int phoneNumber = Integer.parseInt(temp[2]);
                String name = temp[3];
                String birthDay = temp[4];
                String Gender = temp[5];
                String email = temp[6];
                String level = temp[7];
                String workLocation = temp[8];
                double salary = Double.parseDouble(temp[9]);
                employee = new Employee(id, idCard, phoneNumber, name, birthDay, Gender, email, level, workLocation, salary);
                employees.add(employee);
                for (Employee employeeList : employees){
                    System.out.println(employeeList);
                }
            }
        } catch (Exception e) {
            System.err.println("File not found or ERROR!");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return employees;
    }




}
