package newCaseStudy.model.person;

public class Customer extends Person{
    private String typeCustomer, address;

    public Customer(int id, int idCard, int phoneNumber, String name, String birthDay, String gender, String email, String typeCustomer, String address) {
        super(id, idCard, phoneNumber, name, birthDay, gender, email);
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
        return "Customer{" +super.toString()+'\''+
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
