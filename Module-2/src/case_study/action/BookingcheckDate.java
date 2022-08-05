package case_study.action;

import case_study.models.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingcheckDate implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate startDate = LocalDate.parse(o1.getFirstDate(), dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(o1.getLastDate(), dateTimeFormatter);

        if (startDate.compareTo(endDate) < 0){
            return 1;
        }else if (startDate.compareTo(endDate) > 0){
            return -1;
        }else {
                return 0;
        }
    }
}
