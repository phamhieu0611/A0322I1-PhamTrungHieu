package case_sudy.controllers.task2.service;

import case_sudy.controllers.task2.EmployService;
import case_sudy.controllers.task2.human.Employee;
import case_sudy.controllers.task2.repository.EmployeeRepository;
import case_sudy.controllers.task2.repository.EmployeeRepositoryIplm;

import java.util.List;

public class EmployServiceImpl implements EmployService {
    private EmployeeRepository repository = new EmployeeRepositoryIplm();
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        repository.addEmployee(employee);
    }

    @Override
    public void updateEmpoyee(Employee employee) {
        repository.updateEmployee(employee);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id);
    }
}
