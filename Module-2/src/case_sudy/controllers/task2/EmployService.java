package case_sudy.controllers.task2;

import case_sudy.controllers.task2.human.Employee;

import java.util.List;

public interface EmployService {
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void updateEmpoyee(Employee employee);
    void remove(int id);
    Employee findById(int id);
}
