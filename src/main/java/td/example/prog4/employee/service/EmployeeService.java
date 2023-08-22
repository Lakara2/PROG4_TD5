package td.example.prog4.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import td.example.prog4.employee.model.EmployeeFilter;
import td.example.prog4.employee.repository.dao.EmployeeManagerDao;
import td.example.prog4.employee.repository.entity.Employee;
import td.example.prog4.employee.repository.facadeRepository.EmployeeRepositoryFacade;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepositoryFacade repository;
    private EmployeeManagerDao employeeManagerDao;


    public Employee getOne(String id) {
        return repository.findById(id);
    }

    public List<Employee> getAll(EmployeeFilter filter) {
        Sort sort = Sort.by(filter.getOrderDirection(), filter.getOrderBy().toString());
        Pageable pageable = PageRequest.of(filter.getIntPage() - 1, filter.getIntPerPage(), sort);
        return employeeManagerDao.findByCriteria(
                filter.getLastName(),
                filter.getFirstName(),
                filter.getCountryCode(),
                filter.getSex(),
                filter.getPosition(),
                filter.getEntrance(),
                filter.getDeparture(),
                pageable
        );
    }

    public void saveOne(Employee employee) {
        repository.save(employee);
    }
}
