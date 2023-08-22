package td.example.prog4.cnaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import td.example.prog4.cnaps.model.CnapsEmployee;

@Repository
public interface CnapsEmployeeRepository extends JpaRepository<CnapsEmployee, String> {
}
