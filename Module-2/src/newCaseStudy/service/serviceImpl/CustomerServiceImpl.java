package newCaseStudy.service.serviceImpl;

import newCaseStudy.model.person.Customer;
import newCaseStudy.reponsitory.CustomerReponsitory;
import newCaseStudy.reponsitory.reponsitoryImpl.CustomerReponsitoryImpl;
import newCaseStudy.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerReponsitory customerReponsitory = new CustomerReponsitoryImpl();

    @Override
    public List<Customer> displayAll() {
        return customerReponsitory.displayAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerReponsitory.addCustomer(customer);
    }

    @Override
    public void editCustomer(int id, Customer customer) {
        customerReponsitory.editCustomer(id, customer);
    }
}
