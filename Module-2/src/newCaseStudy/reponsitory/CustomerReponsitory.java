package newCaseStudy.reponsitory;

import newCaseStudy.model.person.Customer;

import java.util.List;

public interface CustomerReponsitory {
    List<Customer> displayAll();
    void addCustomer(Customer customer);
    void editCustomer(int id, Customer customer);
}
