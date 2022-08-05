package case_study.service.serviceImpl;

import case_study.action.Validate;
import case_study.action.WriteFile;
import case_study.models.person.Employee;
import case_study.service.EmployeeService;
import java.io.*;
import java.util.*;

import static case_study.action.ReadFile.readEmployeeFile;

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
    public void displayAll() {
        List<Employee> employeeList = readEmployeeFile(FILE_EMPLOYEE_CSV);
        for (Employee employees : employeeList) {
            System.out.println(employees);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_EMPLOYEE_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(employee.getId()+","+employee.getIdCard()+","+employee.getPhoneNumber()+","+employee.getName()+","+employee.getBirthDay()+","+employee.getGender()+","+employee.getEmail()+","+employee.getLevel()+","+employee.getWorkLocation()+","+employee.getSalary());
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            employeeList = (ArrayList<Employee>) readEmployeeFile(FILE_EMPLOYEE_CSV);
        }
    }

    private int indexEmployee(int id)
    {
        int index=-1;
        for (int i=0; i<employeeList.size(); i++)
        {
            if (id==employeeList.get(i).getId())
            {
                index=i;
                break;
            }
        }
        return index;
    }

    @Override
    public void editEmployee() {
        try {
            displayAll();
            System.out.print("Edit Employee ID: ");
            int id=Integer.parseInt(scanner.nextLine());
            int index=indexEmployee(id);
            if(index!=-1)
            {
                System.out.println(employeeList.get(index).toString());
                System.out.println("Edit information:");

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
                    System.out.println("Gender: 0.Other  1.Male  2.Female");
                    System.out.print("Choose: ");
                    String indexSet=scanner.nextLine();
                    if(Validate.checkOneNumber(indexSet))
                    {
                        int input=Integer.parseInt(indexSet);
                        if(input>=0 && input<=2)
                        {
                            gender=arraySet[input];
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
                int indexLevel;
                while (true)
                {
                    System.out.println("Level: 1.Middle School  2.College  3.University  4.After university");
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
                while (true){
                    System.out.println("Location: 1.Receptionist  2.Waiter  3.Specialist  4.Supervisor  5.Manager  6.Director");
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
                employeeList.set(index, new Employee(id, idCard, phoneNumber, name,birthday,gender,email,level,workLocation,salary));
                Collections.sort(employeeList, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getId() - o2.getId();
                    }
                });
                WriteFile.editNewEmployee(employeeList);
                System.out.println("Update complete: "+employeeList.get(index).toString());
            }
            else
            {
                System.out.println("This employee code does not exist!");
            }
        }catch (Exception e)
        {
            System.err.println("Exception "+e.toString());
        }
    }

    public Employee addRegexEmployee()
    {
        while (true){
            try {
                displayAll();
                System.out.println("Enter information (ID can not same): ");

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
                int checkID = indexEmployee(id);
                if (checkID == -1){
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
                        System.out.println("Gender: 0.Other  1.Male  2.Female");
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
                    int indexLevel;
                    while (true)
                    {
                        System.out.println("Level: 1.Middle School  2.College  3.University  4.After university");
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
                    while (true){
                        System.out.println("Location: 1.Receptionist  2.Waiter  3.Specialist  4.Supervisor  5.Manager  6.Director");
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
                }if (checkID == 1){
                    System.out.println("Employee id already exists.");
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
}