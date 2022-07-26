package case_study.models;

public class Contract implements Comparable<Contract>{
    private int contractID;
    private int bookingID;
    private double deposit;
    private double paymnet;
    private int customerID;

    public Contract() {
    }

    public Contract(int contractID, int bookingID, double deposit, double paymnet, int customerID) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.deposit = deposit;
        this.paymnet = paymnet;
        this.customerID = customerID;
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

    @Override
    public String toString() {
        return "Contract{" +
                "contractID=" + contractID +
                ", bookingID=" + bookingID +
                ", deposit=" + deposit +
                ", paymnet=" + paymnet +
                ", customerID=" + customerID +
                '}';
    }

    @Override
    public int compareTo(Contract o) {
        int getBook = o.getBookingID();
        return 0;
    }
}
