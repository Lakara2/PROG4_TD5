package td.example.prog4.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import td.example.prog4.employee.repository.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
