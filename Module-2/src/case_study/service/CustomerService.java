package case_study.service;

import case_study.models.person.Customer;

import java.util.List;

public interface CustomerService extends Service {
    Customer getCustomer(int index);
    void customerShow();
    int sizeListCustomer();
    void displayAll();
    void addCustomer(Customer customer);
    void editCustomer(int index, Customer customer);
    void editCustomer(int id, int idCard, int phoneNumber, String name, String birthDay, String gender, String email, String typeCustomer, String address);
}
