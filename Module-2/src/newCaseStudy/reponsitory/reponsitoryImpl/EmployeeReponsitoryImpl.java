package newCaseStudy.reponsitory.reponsitoryImpl;

import newCaseStudy.model.person.Employee;
import newCaseStudy.reponsitory.EmployeeReponsitory;

import java.util.ArrayList;
import java.util.List;

public class EmployeeReponsitoryImpl implements EmployeeReponsitory {
    private static List<Employee> employeeList;
    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, 18495, 846265, "Hiue", "06/11/2000", "male", "h@gmail.com", "University", "Boss", 7750.50));
        employeeList.add(new Employee(2, 18441, 846456, "Boo", "30/10/2000", "Female", "b@gmail.com", "Junior high school", "Nole", 750.50));
        employeeList.add(new Employee(3, 18434, 846454, "Dom", "07/04/2000", "Female", "d@gmail.com", "Junior high school", "Slave", 770));
    }
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
