package case_sudy.service.serviceImpl;

import case_sudy.models.person.Customer;
import case_sudy.repository.CustomerRepository;
import case_sudy.repository.repositoryImpl.CustomerRepositoryIplm;
import case_sudy.service.CustomerService;

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
