package newCaseStudy.reponsitory.reponsitoryImpl;

import newCaseStudy.model.person.Customer;
import newCaseStudy.reponsitory.CustomerReponsitory;

import java.util.LinkedList;
import java.util.List;

public class CustomerReponsitoryImpl implements CustomerReponsitory {
    private static List<Customer> customerList;
    static {
        customerList = new LinkedList<>();
        customerList.add(new Customer(1, 18439, 8412345, "Wayne", "06/11/2000", "Male", "w@gmail.com", "Diamond", "HaTinh"));
        customerList.add(new Customer(2, 18426, 8494902, "Howard", "24/10/2000", "Male", "h@gmail.com", "Gold", "HaNoi"));
        customerList.add(new Customer(3, 18495, 8412241, "Jade", "24/11/2002", "Female", "j@gmail.com", "Silver", "HaTinh"));
    }
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
