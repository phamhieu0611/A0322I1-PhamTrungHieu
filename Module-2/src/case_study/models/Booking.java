package case_study.models;

public class Booking {
    private int bookingID;
    private String firstDate;
    private String LastDate;
    private int customer;
    private String facility;

    public Booking() {
    }

    public Booking(int bookingID, String firstDate, String lastDate, int customer, String facility) {
        this.bookingID = bookingID;
        this.firstDate = firstDate;
        this.LastDate = lastDate;
        this.customer = customer;
        this.facility = facility;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getLastDate() {
        return LastDate;
    }

    public void setLastDate(String lastDate) {
        LastDate = lastDate;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public String getFacility() {
        return facility;
    }

    public void setFaacility(String facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return
                "bookingID=" + bookingID +
                ", firstDate='" + firstDate + '\'' +
                ", LastDate='" + LastDate + '\'' +
                ", customer ID=" + customer +
                ", faacility ID=" + facility;
    }
}
