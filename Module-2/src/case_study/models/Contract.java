package case_study.models;

import case_study.models.person.Customer;

public class Contract{
    private int contractID;
    private Booking bookingID;
    private double deposit;
    private double paymnet;
    private Customer customerID;

    public Contract() {
    }

    public Contract(int contractID, Booking bookingID, double deposit, double paymnet, Customer customerID) {
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

    public Booking getBookingID() {
        return bookingID;
    }

    public void setBookingID(Booking bookingID) {
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

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return
                "contractID=" + contractID +
                ", bookingID=" + bookingID +
                ", deposit=" + deposit +
                ", paymnet=" + paymnet +
                ", customerID=" + customerID;
    }
}
