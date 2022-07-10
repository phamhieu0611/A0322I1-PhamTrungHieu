package case_sudy.controllers.task2.repository;

import case_sudy.controllers.task2.human.Customer;

import java.util.LinkedList;
import java.util.List;

public class CustomerRepositoryIplm implements CustomerRepository{
    private static List<Customer> customerList;
    static {
        customerList = new LinkedList<>();
        customerList.add(new Customer(1, "Duyen", "24/12/2002", "Female", 1843, 909124, "d@gmail,com", "Diamond", "HaTinh"));
        customerList.add(new Customer(2, "dang", "12/12/2000", "Male", 184312, 632541, "dsng@gmail,com", "silver", "QuangBinh"));
        customerList.add(new Customer(3, "Linh", "16/07/2000", "Female", 184332, 564564, "linh@gmail,com", "gold", "QuangTri"));
        customerList.add(new Customer(4, "Nhii", "05/04/2000", "Female", 184341, 651164, "nhii@gmail,com", "Diamond", "Hue"));
        customerList.add(new Customer(5, "he", "15/11/2000", "Male", 184351, 956651, "he@gmail,com", "bronze", "Laos"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }
}
