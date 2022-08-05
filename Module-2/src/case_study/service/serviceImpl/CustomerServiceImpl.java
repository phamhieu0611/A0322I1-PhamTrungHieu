package case_study.service.serviceImpl;

import case_study.action.Validate;
import case_study.action.WriteFile;
import case_study.models.person.Customer;
import case_study.service.CustomerService;

import java.io.*;
import java.util.*;

import static case_study.action.ReadFile.readCustomerFile;

public class CustomerServiceImpl implements CustomerService {
    private static ArrayList<Customer> customerList;
    private static Scanner scanner = new Scanner(System.in);
    private static final String[] arrayType={null,"Diamond","Platinium","Gold","Silver","Member"};
    private static final String[] arraySet={"Khác","Nam","Nữ"};
    public static final String FILE_CUSTOMER_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\customer.csv";

    static {
        customerList = (ArrayList<Customer>) readCustomerFile(FILE_CUSTOMER_CSV);
    }

    public static ArrayList<Customer> getCustomer(){
        return customerList;
    }

    public static int getSize()
    {
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
            buffWrite.write(customer.getId()+","+customer.getIdCard()+","+customer.getPhoneNumber()+","+customer.getName()+","+customer.getBirthDay()+","+customer.getGender()+","+customer.getEmail()+","+customer.getTypeCustomer()+","+customer.getAddress());
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            customerList = (ArrayList<Customer>) readCustomerFile(FILE_CUSTOMER_CSV);
        }
    }

    @Override
    public void editCustomer() {
            try {
                Scanner scanner=new Scanner(System.in);
                if(customerList.size()==0)
                {
                    System.out.println("Employee list is empty!");
                    return;
                }
                displayAll();
                System.out.print("Edit Employee ID: ");
                int id=scanner.nextInt();
                int index=indexCustomer(id);
                if(index!=-1)
                {
                    System.out.println(customerList.get(index).toString());
                    System.out.println("Edit information:");

                    String idCrd;
                    while (true)
                    {
                    System.out.print("Input ID card: ");
                    idCrd = scanner.nextLine();
                    if (Validate.idCard(idCrd))
                        break;
                    System.out.println("Format (ID Card):xxxxxxxxxxx or (CCCD): xxxxxxxxxxxxxx (x is a number).");
                }
                int idCard = Integer.parseInt(idCrd);
                String phonenum;
                while (true) {
                    System.out.print("Input phone number: ");
                    phonenum = scanner.nextLine();
                    if (Validate.phoneNumber(phonenum))
                        break;
                    System.out.println("Format phone number: 09xxxxxxxxxx or 03xxxxxxxxxx (x is a number).");
                }
                int phoneNumber = Integer.parseInt(phonenum);
                String nameIn;
                while (true) {
                    System.out.print("Input Full name: ");
                    nameIn = scanner.nextLine();
                    if (Validate.nameRegex(nameIn))
                        break;
                    System.out.println("Format name VietNamese or English name.");
                }
                String name = nameIn;
                String birthDayIn;
                while (true) {
                    System.out.print("Input Birthday: ");
                    birthDayIn = scanner.nextLine();
                    if (Validate.dateRegex(birthDayIn))
                        break;
                    System.out.println("Format: dd-MM-yyyy");
                }
                String birthday = birthDayIn;
                String gender;
                while (true) {
                    System.out.println("Gender: 0.Other  1.Male  2.Female");
                    System.out.print("Choose: ");
                    String indexSet = scanner.nextLine();
                    if (Validate.checkOneNumber(indexSet)) {
                        int input = Integer.parseInt(indexSet);
                        if (input >= 0 && input <= 2) {
                            gender = arraySet[input];
                            break;
                        }
                        System.out.println("Please choose again!");
                    }
                }
                String email;
                while (true) {
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    if (Validate.checkEmail(email))
                        break;
                    System.out.println("Email form:(a-z).@gmail.com(.vn or dot something: optional.)");
                }
                System.out.println("Type: 1.Diamond  2.Platinium  3.Gold  4.Silver  5.Member");
                int indexType;
                while (true) {
                    System.out.print("Choose your type: ");
                    String indexTypeStr = scanner.nextLine();
                    if (Validate.checkOneNumber(indexTypeStr)) {
                        indexType = Integer.parseInt(indexTypeStr);
                        if (indexType >= 1 && indexType <= 5)
                            break;
                    }
                    System.out.println("Please re-enter type Customer!");
                }

                String typeCustomer = arrayType[indexType];
                System.out.print("Address: ");
                String address = scanner.nextLine();
                customerList.set(index, new Customer(id, idCard, phoneNumber, name, birthday, gender, email, typeCustomer, address));
                Collections.sort(customerList, new Comparator<Customer>() {
                    @Override
                    public int compare(Customer o1, Customer o2) {
                        return o1.getId() - o2.getId();
                    }
                });
                    WriteFile.editNewCustomer(customerList);
                    System.out.println("Edit complete: "+customerList.get(index).toString());
                }else {
                    System.out.println("Customer ID not found!");
                }
        } catch (Exception e) {
                System.err.println("Exception " + e.toString());
            }
    }


    private int indexCustomer(int id)
    {
        int index=-1;
        for (int i=0; i<customerList.size(); i++)
        {
            if (id==customerList.get(i).getId())
            {
                index=i;
                break;
            }
        }
        return index;
    }

    public Customer getCustomer(int id)
    {
        int index=indexCustomer(id);
        if(index!=-1)
        {
            return customerList.get(index);
        }
        return null;
    }

    public Customer addRegexCustomer(){
        while (true){
            try {
                displayAll();
                System.out.println("Enter information: ");
                String idStr;
                while (true)
                {
                    System.out.print("Input ID (Id can not same): ");
                    idStr=scanner.nextLine();
                    if(Validate.checkId(idStr))
                        break;
                    System.out.println("Format ID: xxxx (x is a number).");
                }
                int id=Integer.parseInt(idStr);
                int checkID = indexCustomer(id);
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
                }if (checkID == 1){
                    System.out.println("customer id already exists.");
                }
            }catch (Exception e){
        System.err.println("Exception "+e.toString());
    }
}
    }

    public void addNew(Customer customer) {
        if(customer!=null)
        {
            customerList.add(customer);
            VoucherService.addToVoucher(customer.getId());
            Collections.sort(customerList, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getId() - o2.getId();
                }
            });
            WriteFile.writeCustomer(FILE_CUSTOMER_CSV,customer);
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }

    }
}
