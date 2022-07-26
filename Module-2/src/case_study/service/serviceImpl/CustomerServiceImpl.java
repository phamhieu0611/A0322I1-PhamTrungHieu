package case_study.service.serviceImpl;

import case_study.models.person.Customer;
import case_study.service.CustomerService;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList;

    @Override
    public List<Customer> displayAll() {
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void editCustomer(int id, Customer customer) {
        for (int i = 0; i < customerList.size(); i++){
            if (i == customerList.get(i).getId()){
                i = id;
                break;
            }
        }customerList.set(id, customer);
    }
}
