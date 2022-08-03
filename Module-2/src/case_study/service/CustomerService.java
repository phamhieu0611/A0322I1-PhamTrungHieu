package case_study.service;

import case_study.models.person.Customer;

public interface CustomerService extends Service {
    void displayAll();
    void addCustomer(Customer customer);
    void editCustomer();
}
