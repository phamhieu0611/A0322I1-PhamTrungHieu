package case_sudy.controllers.task2.models;

public class Contract {
    private int idContract;
    private int idBookng;
    private int deposit;
    private int totalPrice;
    private int idCustomer;

    public Contract(int idContract, int idBookng, int deposit, int totalPrice, int idCustomer) {
        this.idContract = idContract;
        this.idBookng = idBookng;
        this.deposit = deposit;
        this.totalPrice = totalPrice;
        this.idCustomer = idCustomer;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdBookng() {
        return idBookng;
    }

    public void setIdBookng(int idBookng) {
        this.idBookng = idBookng;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + getIdContract() +
                ", idBookng=" + getIdBookng() +
                ", deposit=" + getDeposit() +
                ", totalPrice=" + getTotalPrice() +
                ", idCustomer=" + getIdCustomer() +
                '}';
    }
}
