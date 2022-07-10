package case_sudy.controllers.task2;

import case_sudy.controllers.task2.human.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void remove(int id);
    Customer findById(int id);
}
