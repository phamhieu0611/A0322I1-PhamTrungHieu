package case_sudy.controllers.task2.repository;

import case_sudy.controllers.task2.human.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void remove(int id);
    Customer findById(int id);
}
