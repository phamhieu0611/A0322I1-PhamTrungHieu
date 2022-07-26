package case_study.service.serviceImpl;


import case_study.models.person.Employee;
import case_study.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList;
    @Override
    public List<Employee> displayAll() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        for (int i = 0; i < employeeList.size(); i++){
            if (id == employeeList.get(i).getId()){
                id = i;
                break;
            }
        }employeeList.set(id, employee);
    }
}

