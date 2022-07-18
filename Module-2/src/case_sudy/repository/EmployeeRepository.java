package case_sudy.repository;

import case_sudy.models.person.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void updateEmployee(int id, Employee employee);
}
