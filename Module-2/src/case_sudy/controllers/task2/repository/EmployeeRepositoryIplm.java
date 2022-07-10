package case_sudy.controllers.task2.repository;

import case_sudy.controllers.task2.human.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryIplm implements EmployeeRepository{
    private static List<Employee> employeeList;
    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Wayne", "01/01/2000", "Male", 12345, 555666777, "wayne@gmail.com", "Universiry", "Manager", 5000));
        employeeList.add(new Employee(2, "Howard", "02/02/2000", "Male", 12346, 555666778, "howard@gmail.com", "Universiry", "Leader", 7500));
        employeeList.add(new Employee(3, "Linda", "03/03/2000", "Female", 12347, 555666779, "linda@gmail.com", "Hight schol", "Le Tan", 2000));
        employeeList.add(new Employee(4, "Jade", "04/04/2000", "Female", 12348, 555666771, "jade@gmail.com", "Universiry", "Giam doc", 10000));
        employeeList.add(new Employee(5, "Leon", "06/0/2000", "Male", 123459, 555666772, "leon@gmail.com", "Universiry", "Manager", 5000));
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void remove(int id) {
        employeeList.remove(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeList.get(id);
    }
}
