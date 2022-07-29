package case_study.service.serviceImpl;

import case_study.action.Validate;
import case_study.models.person.Customer;
import case_study.service.CustomerService;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static LinkedList<Customer> customerList;
    private static Scanner scanner = new Scanner(System.in);
    private static final String[] arrayType={null,"Diamond","Platinium","Gold","Silver","Member"};
    private static final String[] arraySet={"Khác","Nam","Nữ"};
    public static final String FILE_CUSTOMER_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\customer.csv";

    static {
        customerList = (LinkedList<Customer>) readCustomerFile(FILE_CUSTOMER_CSV);
    }

    public static LinkedList<Customer> getCustomer(){
        return customerList;
    }

    public static List<Customer> readCustomerFile(String filePath){
        List<Customer> customers = new LinkedList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Customer customer;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                int idCus = Integer.parseInt(temp[0]);
                int idCard = Integer.parseInt(temp[1]);
                int phoneNumber = Integer.parseInt(temp[2]);
                String name = temp[3];
                String birthDay = temp[4];
                String Gender = temp[5];
                String email = temp[6];
                String typeCustomer = temp[7];
                String address = temp[8];
                customer = new Customer(idCus, idCard, phoneNumber, name, birthDay, Gender, email, typeCustomer, address);
                customers.add(customer);
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
        }return customers;
    }

    @Override
    public Customer getCustomer(int index) {
        return customerList.get(index);
    }

    @Override
    public void customerShow() {
        Iterator<Customer> iterator = customerList.iterator();
        int index = 0;
        while (iterator.hasNext()){
            Customer customer = iterator.next();
            System.out.println("ID: "+(index++)+" "+customer.toString());
        }
    }

    @Override
    public int sizeListCustomer() {
        return customerList.size();
    }

    @Override
    public void displayAll() {
        List<Customer> customerList = readCustomerFile(FILE_CUSTOMER_CSV);
        for (Customer customers : customerList){
            System.out.println(customers);
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_CUSTOMER_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.newLine();
            buffWrite.write(customer.getId()+","+customer.getIdCard()+","+customer.getPhoneNumber()+","+customer.getName()+","+customer.getBirthDay()+","+customer.getGender()+","+customer.getEmail()+","+customer.getTypeCustomer()+","+customer.getAddress());
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer addRegexCustomer(){
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
        System.out.println("Type: 1.Diamond  2.Platinium  3.Gold  4.Silver  5.Member");
        int indexType;
        while (true) {
            System.out.print("Choose your type: ");
            String indexTypeStr = scanner.nextLine();
            if (Validate.checkOneNumber(indexTypeStr))
            {
                indexType=Integer.parseInt(indexTypeStr);
                if(indexType>=1 && indexType<=5)
                    break;
            }
            System.out.println("Please re-enter type Customer!");
        }

        String typeCustomer = arrayType[indexType];
        System.out.print("Address: ");
        String address = scanner.nextLine();
        return new Customer(id, idCard, phoneNumber, name, birthday, gender, email, typeCustomer, address);
    }catch (Exception e){
        System.err.println("Exception "+e.toString());
    }
}
    }

    @Override
    public void editCustomer(int index, Customer customer) {
        customerList.set(index, customer);
    }

    @Override
    public void editCustomer(int id, int idCard, int phoneNumber, String name, String birthDay, String gender, String email, String typeCustomer, String address) {
        Customer editCustomer = customerList.get(id);
        editCustomer.setIdCard(idCard);
        editCustomer.setPhoneNumber(phoneNumber);
        editCustomer.setName(name);
        editCustomer.setBirthDay(birthDay);
        editCustomer.setGender(gender);
        editCustomer.setEmail(email);
        editCustomer.setTypeCustomer(typeCustomer);
        editCustomer.setAddress(address);
    }
}
