package case_sudy.service;

import case_sudy.models.person.Customer;

import java.util.List;

public interface CustomerService extends Service{
    List<Customer> findAll();
    void addCustomer(Customer customer);
    void updateCustomer(int id, Customer customer);
}
