package case_study.models;

public class Contract{
    private int contractID;
    private int bookingID;
    private int customerID;
    private String facilityID;
    private String startDate;
    private String endDate;
    private double deposit;
    private double paymnet;

    public Contract() {
    }

    public Contract(int contractID, int bookingID, int customerID, String facilityID, String startDate, String endDate, double deposit, double paymnet) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.facilityID = facilityID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.paymnet = paymnet;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPaymnet() {
        return paymnet;
    }

    public void setPaymnet(double paymnet) {
        this.paymnet = paymnet;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    @Override
    public String toString() {
        return
                "contractID=" + contractID +
                ", bookingID=" + bookingID +
                ", customerID=" + customerID +
                ", facilityID='" + facilityID + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", deposit=" + deposit +
                ", paymnet=" + paymnet;
    }
}
