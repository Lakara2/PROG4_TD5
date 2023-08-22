package td.example.prog4.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import td.example.prog4.employee.repository.entity.Position;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {
    Optional<Position> findPositionByNameEquals(String name);
}
