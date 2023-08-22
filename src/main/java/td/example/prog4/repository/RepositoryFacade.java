package td.example.prog4.repository;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import td.example.prog4.cnaps.model.CnapsEmployee;
import td.example.prog4.cnaps.repository.CnapsEmployeeRepository;
import td.example.prog4.employee.model.exception.NotFoundException;
import td.example.prog4.employee.repository.EmployeeRepository;
import td.example.prog4.employee.repository.entity.Employee;

@Service
@AllArgsConstructor
public class RepositoryFacade {
  private final EmployeeRepository employeeRepository;
  private final CnapsEmployeeRepository cnapsEmployeeRepository;

  public Employee findById(String id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    if (employee.isEmpty()) {
      throw new NotFoundException("Employee.Id=" + id + " was not found");
    }

    Optional<CnapsEmployee> cnaps = cnapsEmployeeRepository.findById(id);
    Employee result = employee.get();
    result.setCnaps(cnaps.get().getCnaps());

    return result;
  }

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }
}