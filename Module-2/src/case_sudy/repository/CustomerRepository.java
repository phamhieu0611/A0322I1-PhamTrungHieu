package case_sudy.repository;

import case_sudy.models.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void addCustomer(Customer customer);
    void updateCustomer(int id, Customer customer);
}
