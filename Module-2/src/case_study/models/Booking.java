package case_study.models;

import case_study.models.facility.Facility;
import case_study.models.person.Customer;

public class Booking {
    private int bookingID;
    private String firstDate;
    private String LastDate;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(int bookingID, String firstDate, String lastDate, Customer customer, Facility facility) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFaacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return
                "bookingID=" + bookingID +
                ", firstDate='" + firstDate + '\'' +
                ", LastDate='" + LastDate + '\'' +
                ", customer=" + customer +
                ", faacility=" + facility;
    }
}
