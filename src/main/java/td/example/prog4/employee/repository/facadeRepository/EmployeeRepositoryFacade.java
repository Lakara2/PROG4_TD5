package td.example.prog4.employee.repository.facadeRepository;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import td.example.prog4.cnaps.model.CnapsEmployee;
import td.example.prog4.cnaps.repository.CnapsEmployeeRepository;
import td.example.prog4.employee.controller.mapper.EmployeeMapper;
import td.example.prog4.employee.model.exception.NotFoundException;
import td.example.prog4.employee.repository.EmployeeRepository;
import td.example.prog4.employee.repository.entity.Employee;

@Repository
@Primary
@AllArgsConstructor
public class EmployeeRepositoryFacade implements UserConnectorRepository {
    private final EmployeeRepository employeeRepository;
    private final CnapsEmployeeRepository cnapsEmployeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Employee findById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found id=" + id));
        CnapsEmployee cnapsEmployee = cnapsEmployeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found id=" + id));
        return employeeMapper.toCnapsEmployeeView(employee,cnapsEmployee);
    }



    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
        cnapsEmployeeRepository.save(employeeMapper.toCnapsEmployeeDomain(employee));
    }

}
