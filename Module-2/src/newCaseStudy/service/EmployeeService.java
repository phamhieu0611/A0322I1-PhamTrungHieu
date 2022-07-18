package newCaseStudy.service;

import newCaseStudy.model.person.Employee;

import java.util.List;

public interface EmployeeService extends Service{
    List<Employee> displayAll();
    void addEmployee(Employee employee);
    void editEmployee(int id, Employee employee);
}
