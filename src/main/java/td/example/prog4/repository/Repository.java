package td.example.prog4.repository;

import td.example.prog4.employee.repository.entity.Employee;

public interface Repository {
    Employee findById(String id);
    Employee save(Employee employee);
}
