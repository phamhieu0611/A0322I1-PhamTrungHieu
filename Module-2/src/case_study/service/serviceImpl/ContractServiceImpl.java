package case_study.service.serviceImpl;

import case_study.action.WriteFile;
import case_study.models.Booking;
import case_study.models.Contract;
import case_study.models.person.Customer;
import case_study.service.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {

    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void makeNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendData();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        try {
            while (!bookingQueue.isEmpty()) {
                Booking booking = bookingQueue.poll();
                Customer customer = booking.getCustomer();
                System.out.println("Creating contract for booking, infomation " + booking.toString());
                System.out.println("Creating contract for customer, infomation " + customer.toString());
                System.out.print("Input Contract ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Input deposit: ");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.print("Input total cost: ");
                double paymnet = Double.parseDouble(scanner.nextLine());

                Contract contract = new Contract(id, booking, deposit, paymnet, customer);
                contractList.add(contract);
                WriteFile.addNewContract(contract);
                System.out.println("Creating contract successful: " + contract.toString());
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void displayContract() {
        for (Contract contract : contractList){
            System.out.println(contract.toString());
        }
    }

    @Override
    public void editContract() {

    }
}
