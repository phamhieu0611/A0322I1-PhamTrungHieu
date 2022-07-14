package case_sudy.service;

import case_sudy.models.Customer;
import case_sudy.repository.CustomerRepository;
import case_sudy.repository.CustomerRepositoryIplm;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository = new CustomerRepositoryIplm();
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        repository.addCustomer(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        repository.updateCustomer(id, customer);
    }
}
