package case_study.service;

import case_study.models.person.Employee;

public interface EmployeeService extends Service{
    void displayAll();
    void addEmployee(Employee employee);
    void editEmployee();
}
