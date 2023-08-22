package td.example.prog4.employee.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"position\"")
@EqualsAndHashCode
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = AUTO)
    private String id;
    private String name;
}
