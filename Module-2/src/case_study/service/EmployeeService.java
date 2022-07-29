package case_study.service;

import case_study.models.person.Employee;

public interface EmployeeService extends Service{
    Employee getEmployee(int index);
    void employeeShow();
    int sizeListEmployee();
    void displayAll();
    void addEmployee(Employee employee);
    void editEmployee(int index, Employee employee);
    void editEmployee(int id, int idCard, int phoneNumber, String name, String birthDay, String gender, String email, String level, String workLocation, double salary);
}
