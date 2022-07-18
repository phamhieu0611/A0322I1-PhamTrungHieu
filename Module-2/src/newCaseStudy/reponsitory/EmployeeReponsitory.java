package newCaseStudy.reponsitory;

import newCaseStudy.model.person.Employee;

import java.util.List;

public interface EmployeeReponsitory {
    List<Employee> displayAll();
    void addEmployee(Employee employee);
    void editEmployee(int id, Employee employee);
}
