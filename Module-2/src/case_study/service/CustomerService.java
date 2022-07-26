package case_study.service;

import case_study.models.person.Customer;

import java.util.List;

public interface CustomerService extends Service {
    List<Customer> displayAll();
    void addCustomer(Customer customer);
    void editCustomer(int id, Customer customer);
}
