package case_study.service.serviceImpl;

import case_study.models.Booking;
import case_study.models.person.Customer;
import case_study.service.PromotionService;

import java.util.Set;
import java.util.TreeSet;

import static case_study.action.ReadFile.readBookingFile;

public class PromotionServiceImpl implements PromotionService {
    private static final String FILE_BOOKING_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\booking.csv";
    private static Set<Booking> bookingSet = new BookingServiceImpl().sendData();
    private static TreeSet<Integer> customerUseService = new TreeSet<>();
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();

    static {
        readBookingFile(FILE_BOOKING_CSV, bookingSet);
    }

    @Override
    public void displayUserService() {
        System.out.println("List customer use Serice: ");
        for (Booking booking : bookingSet) {
            customerUseService.add(booking.getCustomer());
        }
        if(customerUseService.size()==0)
        {
            System.out.println("Empty list!");
        }if (customerUseService.size()!=0){
            for (Integer integer:customerUseService) {
                Customer customer = customerService.getCustomer(integer);
                System.out.println(customer.toString());
            }
        }
    }

    @Override
    public void displayGetVoucherService() {
        VoucherService.disPlay();
    }
}
