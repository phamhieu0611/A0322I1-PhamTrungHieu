package case_study.service.serviceImpl;

import case_study.action.WriteFile;
import case_study.models.Booking;
import case_study.models.Contract;
import case_study.service.BookingService;

import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    private static final String[] arrayNameService={null,"Villa","Room","House"};
    private static Scanner scanner=new Scanner(System.in);
    private static TreeSet<Booking> arrayBooking=new TreeSet<>();
    private static TreeSet<Contract> arrayContract=new TreeSet<>();
    private static CustomerServiceImpl customerService=new CustomerServiceImpl();
    @Override
    public void makeNewContract(Contract contract) {
        if(contract!=null)
        {
            System.out.println("Contract created: "+contract);
            arrayContract.add(contract);
            WriteFile.writeToContract("C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\newCaseStudy\\data\\contract.csv",arrayContract);
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
    }

    @Override
    public void displayContract() {
        System.out.println("List of contract: ");
        if(arrayBooking.size()==0)
        {
            System.out.println("Empty list!");
        }
        else
        {
            for (Contract contract:arrayContract)
            {
                System.out.println(contract.toString());
            }
        }
    }

    @Override
    public void editContract() {

    }
}
