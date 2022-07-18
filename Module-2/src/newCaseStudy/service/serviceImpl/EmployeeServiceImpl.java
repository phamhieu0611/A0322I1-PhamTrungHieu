package newCaseStudy.service.serviceImpl;


import newCaseStudy.model.person.Employee;
import newCaseStudy.reponsitory.EmployeeReponsitory;
import newCaseStudy.reponsitory.reponsitoryImpl.EmployeeReponsitoryImpl;
import newCaseStudy.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeReponsitory employeeReponsitory = new EmployeeReponsitoryImpl();
    @Override
    public List<Employee> displayAll() {
        return employeeReponsitory.displayAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeReponsitory.addEmployee(employee);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        employeeReponsitory.editEmployee(id, employee);
    }
}
