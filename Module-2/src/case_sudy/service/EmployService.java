package case_sudy.service;

import case_sudy.models.Employee;

import java.util.List;

public interface EmployService extends Service{
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void updateEmpoyee(int id, Employee employee);
}
