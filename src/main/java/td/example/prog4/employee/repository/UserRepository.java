package td.example.prog4.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import td.example.prog4.employee.repository.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select * from \"user\" u where u.username = :username limit 1", nativeQuery = true)
    Optional<User> findOneByUsername(@Param("username") String username);
}
