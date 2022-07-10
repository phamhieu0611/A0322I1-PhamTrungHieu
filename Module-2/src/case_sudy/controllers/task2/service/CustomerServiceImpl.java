package case_sudy.controllers.task2.service;

import case_sudy.controllers.task2.CustomerService;
import case_sudy.controllers.task2.human.Customer;
import case_sudy.controllers.task2.repository.CustomerRepository;
import case_sudy.controllers.task2.repository.CustomerRepositoryIplm;

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
    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }
}
