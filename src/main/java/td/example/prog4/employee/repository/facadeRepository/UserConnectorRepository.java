package td.example.prog4.employee.repository.facadeRepository;

import td.example.prog4.employee.repository.entity.Employee;

public interface UserConnectorRepository {

        Employee findById(String id);

        void save(Employee employee);

    }

