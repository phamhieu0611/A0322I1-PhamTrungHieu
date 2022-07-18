package newCaseStudy.service;

import newCaseStudy.model.person.Customer;

import java.util.List;

public interface CustomerService extends Service {
    List<Customer> displayAll();
    void addCustomer(Customer customer);
    void editCustomer(int id, Customer customer);
}
