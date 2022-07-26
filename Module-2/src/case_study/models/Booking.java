package case_study.models;

import java.util.Date;

public class Booking implements Comparable<Booking> {
    private int bookingID;
    private Date firstDate;
    private Date LastDate;
    private int CustomerID;
    private String facilityName;
    private String facilityType;

    public Booking() {
    }

    public Booking(int bookingID, Date firstDate, Date lastDate, int customerID, String facilityName, String facilityType) {
        this.bookingID = bookingID;
        this.firstDate = firstDate;
        LastDate = lastDate;
        CustomerID = customerID;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getLastDate() {
        return LastDate;
    }

    public void setLastDate(Date lastDate) {
        LastDate = lastDate;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", firstDate=" + firstDate +
                ", LastDate=" + LastDate +
                ", CustomerID=" + CustomerID +
                ", facilityName='" + facilityName + '\'' +
                ", facilityType='" + facilityType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        return this.getFirstDate().compareTo(o.getFirstDate());
    }
}
