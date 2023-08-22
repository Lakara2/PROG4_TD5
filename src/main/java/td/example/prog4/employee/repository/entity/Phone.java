package td.example.prog4.employee.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"phone\"")
@EqualsAndHashCode
@ToString
public class Phone {
    @Id
    @GeneratedValue(strategy = AUTO)
    private String id;
    private String value;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;
}
