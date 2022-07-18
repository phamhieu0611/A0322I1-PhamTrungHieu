package case_sudy.models.person;

public class Customer extends Person{
    private String typeCustomer;
    private String address;

    public Customer(int id, String name, String birthDay, String gender, int idCard, int phoneNumber, String email, String typeCustomer, String address) {
        super(id, name, birthDay, gender, idCard, phoneNumber, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +super.toString()+
                "\ntypeCustomer='" + getTypeCustomer() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
