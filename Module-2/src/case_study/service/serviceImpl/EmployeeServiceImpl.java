package case_study.service.serviceImpl;


import case_study.action.Validate;
import case_study.models.person.Customer;
import case_study.models.person.Employee;
import case_study.service.EmployeeService;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String[] arraySet={"Khác","Nam","Nữ"};
    private static final String[] arrayLevel={null,"Intermediate","College","Undergraduate","Graduate"};
    private static final String[] arrayLocation={null,"Receptionist","Waiter","Specialist","Supervisor","Manager","Director"};
    private static ArrayList<Employee> employeeList;
    public static final String FILE_EMPLOYEE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\employee.csv";

    static {
        employeeList = (ArrayList<Employee>) readEmployeeFile(FILE_EMPLOYEE_CSV);
    }

    @Override
    public Employee getEmployee(int index) {
        return employeeList.get(index);
    }

    @Override
    public void employeeShow() {
        Iterator<Employee> iterator = employeeList.iterator();
        int index = 0;
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println("ID: "+(index++)+" "+employee.toString());
        }
    }

    @Override
    public int sizeListEmployee() {
        return employeeList.size();
    }

    @Override
    public void displayAll() {
        List<Employee> employeeList = readEmployeeFile(FILE_EMPLOYEE_CSV);
        for (Employee employees : employeeList) {
            System.out.println(employees);
        }
    }

    public static List<Employee> checkDuplicate(String filePath){
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
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return employees;
    }

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
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_EMPLOYEE_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.newLine();
            buffWrite.write(employee.getId()+","+employee.getIdCard()+","+employee.getPhoneNumber()+","+employee.getName()+","+employee.getBirthDay()+","+employee.getGender()+","+employee.getEmail()+","+employee.getLevel()+","+employee.getWorkLocation()+","+employee.getSalary());
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Employee addRegexEmployee()
    {
        while (true){
            try {
        System.out.println("Enter information: ");
        String idStr;
        while (true)
        {
            System.out.print("ID: ");
            idStr=scanner.nextLine();
            if(Validate.checkId(idStr))
                break;
            System.out.println("Format ID: xxxx (x is a number).");
        }
        int id=Integer.parseInt(idStr);
        String idCrd;
                while (true)
                {
                    System.out.print("Input ID card: ");
                    idCrd=scanner.nextLine();
                    if(Validate.idCard(idCrd))
                        break;
                    System.out.println("Format (ID Card):xxxxxxxxxxx or (CCCD): xxxxxxxxxxxxxx (x is a number).");
                }
        int idCard = Integer.parseInt(idCrd);
        String phonenum;
                while (true)
                {
                    System.out.print("Input phone number: ");
                    phonenum=scanner.nextLine();
                    if(Validate.phoneNumber(phonenum))
                        break;
                    System.out.println("Format phone number: 09xxxxxxxxxx or 03xxxxxxxxxx (x is a number).");
                }
        int phoneNumber=Integer.parseInt(phonenum);
                String nameIn;
                while (true)
                {
                    System.out.print("Input Full name: ");
                    nameIn=scanner.nextLine();
                    if(Validate.nameRegex(nameIn))
                        break;
                    System.out.println("Format name VietNamese or English name.");
                }
        String name = nameIn;
                String birthDayIn;
                while (true)
                {
                    System.out.print("Input Birthday: ");
                    birthDayIn=scanner.nextLine();
                    if(Validate.dateRegex(birthDayIn))
                        break;
                    System.out.println("Format: dd-MM-yyyy");
                }
        String birthday = birthDayIn;
        String gender;
        while (true)
        {
            System.out.println("Set: 0.Other  1.Male  2.Female");
            System.out.print("Choose: ");
            String indexSet=scanner.nextLine();
            if(Validate.checkOneNumber(indexSet))
            {
                int index=Integer.parseInt(indexSet);
                if(index>=0 && index<=2)
                {
                    gender=arraySet[index];
                    break;
                }
                System.out.println("Please choose again!");
            }
        }
        String email;
        while (true)
        {
            System.out.print("Email: ");
            email=scanner.nextLine();
            if(Validate.checkEmail(email))
                break;
            System.out.println("Email form:(a-z).@gmail.com(.vn or dot something: optional.)");
        }
        System.out.println("Level: 1.Middle School  2.College  3.University  4.After university");
        int indexLevel;
        while (true)
        {
            System.out.print("Choose your level: ");
            String indexLevelStr=scanner.nextLine();
            if(Validate.checkOneNumber(indexLevelStr))
            {
                indexLevel=Integer.parseInt(indexLevelStr);
                if(indexLevel<=4 && indexLevel>=1)
                {
                    break;
                }
            }
            System.out.println("Please re-enter room!");
        }

        String level=arrayLevel[indexLevel];

        int indexLocation;
        System.out.println("Location: 1.Receptionist  2.Waiter  3.Specialist  4.Supervisor  5.Manager  6.Director");
        while (true){
            System.out.print("Choose your location: ");
            String indexStr=scanner.nextLine();
            if(Validate.checkOneNumber(indexStr))
            {
                indexLocation=Integer.parseInt(indexStr);
                if(indexLocation<=6 && indexLocation>=1)
                {
                    break;
                }
            }
            System.out.println("Please re-enter room!");
        }
        String workLocation=arrayLocation[indexLocation];
        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        return new Employee(id, idCard, phoneNumber, name,birthday,gender,email,level,workLocation,salary);
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }


    @Override
    public void editEmployee(int index, Employee employee) {
        employeeList.set(index, employee);
    }

    @Override
    public void editEmployee(int id, int idCard, int phoneNumber, String name, String birthDay, String gender, String email, String level, String workLocation, double salary) {
        Employee editEmployee = employeeList.get(id);
        editEmployee.setIdCard(idCard);
        editEmployee.setPhoneNumber(phoneNumber);
        editEmployee.setName(name);
        editEmployee.setBirthDay(birthDay);
        editEmployee.setGender(gender);
        editEmployee.setEmail(email);
        editEmployee.setLevel(level);
        editEmployee.setWorkLocation(workLocation);
        editEmployee.setSalary(salary);
    }
}