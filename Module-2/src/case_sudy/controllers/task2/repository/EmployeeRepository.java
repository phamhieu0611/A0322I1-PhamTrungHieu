package case_sudy.controllers.task2.repository;

import case_sudy.controllers.task2.human.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void remove(int id);
    Employee findById(int id);
}
