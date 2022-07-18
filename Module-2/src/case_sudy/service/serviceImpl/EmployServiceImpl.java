package case_sudy.service.serviceImpl;

import case_sudy.models.person.Employee;
import case_sudy.repository.EmployeeRepository;
import case_sudy.repository.repositoryImpl.EmployeeRepositoryIplm;
import case_sudy.service.EmployService;

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
    public void updateEmpoyee(int id, Employee employee) {
        repository.updateEmployee(id, employee);
    }
}
