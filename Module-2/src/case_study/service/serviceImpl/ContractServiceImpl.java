package case_study.service.serviceImpl;

import case_study.action.Validate;
import case_study.action.WriteFile;
import case_study.models.Booking;
import case_study.models.Contract;
import case_study.service.ContractService;

import static case_study.action.ReadFile.readBookingFile;
import static case_study.action.ReadFile.readContractFile;


import java.util.*;

public class ContractServiceImpl implements ContractService {
    private static ArrayList<Contract> contractArrayList;
    private static final String FILE_BOOKING_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\booking.csv";
    private static final String FILE_CONTRACT_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\contract.csv";
    private static Scanner scanner = new Scanner(System.in);
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    private static Set<Booking> bookingSet = new BookingServiceImpl().sendData();


    static {
        contractArrayList = (ArrayList<Contract>) readContractFile(FILE_CONTRACT_CSV);
        readBookingFile(FILE_BOOKING_CSV, bookingSet);
    }
    @Override
    public void makeNewContract() {
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        try {
            while (!bookingQueue.isEmpty()) {
                int bookingID = bookingQueue.peek().getBookingID();
                int customerID = bookingQueue.peek().getCustomer();
                String startDate = bookingQueue.peek().getFirstDate();
                String endDate = bookingQueue.peek().getLastDate();
                String facilityID = bookingQueue.peek().getFacility();
                System.out.println("Creating contract for booking, booking ID " + bookingID);
                System.out.println("Creating contract for customer, Customer ID " + customerID);
                displayContract();
                String inputID;
                while (true){
                    System.out.print("Input Contract ID: ");
                    inputID = scanner.nextLine();
                    if (Validate.checkId(inputID))
                        break;
                    System.out.println("Format ID: xxxx (x is a number).");
                }
                int contractID = Integer.parseInt(inputID);
                int checkID = indexContract(contractID);
                if (checkID == -1){
                    double inputDeposit;
                    while (true){
                        System.out.print("Input deposit: ");
                        inputDeposit = Double.parseDouble(scanner.nextLine());
                        if (inputDeposit > 30.0)
                            break;
                        System.out.println("Deposit can not less then 30.0");
                    }
                    double deposit = inputDeposit;
                    double inputPaymnet;
                    while (true){
                        System.out.print("Input total cost: ");
                        inputPaymnet = Double.parseDouble(scanner.nextLine());
                        if (inputPaymnet > deposit)
                            break;
                        System.out.println("Paymnet can not less than deposit");
                    }
                    double paymnet = inputPaymnet;
                    Contract contract = new Contract(contractID, bookingID, customerID, facilityID, startDate, endDate, deposit, paymnet);
                    contractArrayList.add(contract);
                    WriteFile.addNewContract(contract);
                    System.out.println("Creating contract successful: " + contract.toString());
                    bookingQueue.poll();
                    bookingQueue.poll();
                }if (checkID == 0){
                    System.out.println("Contract id already exists.");
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void displayContract() {
        System.out.println("Contract list: ");
        List<Contract> contractList = readContractFile(FILE_CONTRACT_CSV);
        for (Contract contract : contractList){
            System.out.println(contract.toString());
        }
        System.out.println("\n");
    }

    @Override
    public void editContract() {
            try {
                if (contractArrayList.size() == 0){
                    System.out.println("Contract list is empty.");
                    return;
                }
                for (Contract contract: contractArrayList){
                    System.out.println(contract);
                }
                System.out.println("Edit contract by id: ");
                int id = Integer.parseInt(scanner.nextLine());
                int index = indexContract(id);
                if (index != -1){
                    System.out.println(contractArrayList.get(index).toString());
                    System.out.println("Edit infomation: ");
                    String idInput;
                    while (true){
                        System.out.println("Input new booking id: ");
                        idInput = scanner.nextLine();
                        if (Validate.checkId(idInput))
                            break;
                        System.out.println("Format ID: xxxx (x is a number).");
                    }
                    int bookingID = Integer.parseInt(idInput);
                    String idCustomer;
                    while (true)
                    {
                        System.out.print("Input new customer ID: ");
                        idCustomer=scanner.nextLine();
                        if(Validate.checkId(idCustomer))
                            break;
                        System.out.println("Format ID: xxxx (x is a number).");
                    }
                    int customerID=Integer.parseInt(idCustomer);
                    String facilitiIDInput;
                    while (true){
                        System.out.print("Input new facility ID:");
                        facilitiIDInput = scanner.nextLine();
                        if (Validate.checkIDFacility(facilitiIDInput))
                            break;
                        System.out.println("Format Facility Id: SVXX-YYYY (with XX: House is HO and YYYY is number 0-9).");
                    }
                    String facilityID = facilitiIDInput;
                    String inputDayStart;
                    while (true){
                        System.out.print("Input new starting day rent: ");
                        inputDayStart = scanner.nextLine();
                        if (Validate.dateRegex(inputDayStart))
                            break;
                        System.out.println("Format: dd-MM-yyyy");
                    }
                    String startDate = inputDayStart;
                    String inputDayEnd;
                    while (true){
                        System.out.print("Input new end day rent: ");
                        inputDayEnd = scanner.nextLine();
                        if (Validate.dateRegex(inputDayEnd))
                            break;
                        System.out.println("Format: dd-MM-yyyy");
                    }
                    String endDate = inputDayEnd;
                    double inputDeposit;
                    while (true){
                        System.out.print("Input new deposit: ");
                        inputDeposit = Double.parseDouble(scanner.nextLine());
                        if (inputDeposit > 30.0)
                            break;
                        System.out.println("Deposit can not less then 30.0");
                    }
                    double deposit = inputDeposit;
                    double inputPaymnet;
                    while (true){
                        System.out.print("Input new total cost: ");
                        inputPaymnet = Double.parseDouble(scanner.nextLine());
                        if (inputPaymnet > deposit)
                            break;
                        System.out.println("Paymnet can not less than deposit");
                    }
                    double paymnet = inputPaymnet;
                    contractArrayList.set(index, new Contract(id, bookingID, customerID, facilityID, startDate, endDate, deposit, paymnet));
                    Collections.sort(contractArrayList, new Comparator<Contract>() {
                        @Override
                        public int compare(Contract o1, Contract o2) {
                            return o1.getContractID() - o2.getContractID();
                        }
                    });
                    WriteFile.editNewContract(contractArrayList);
                    System.out.println("Edit complete: "+contractArrayList.get(index).toString());
                }else {
                    System.out.println("Contract ID not found!");
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }

    private int indexContract(int id)
    {
        int index=-1;
        for (int i=0; i<contractArrayList.size(); i++)
        {
            if (id==contractArrayList.get(i).getContractID())
            {
                index=i;
                break;
            }
        }
        return index;
    }
}
