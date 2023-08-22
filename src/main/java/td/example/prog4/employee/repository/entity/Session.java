package td.example.prog4.employee.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"session\"")
@EqualsAndHashCode
@ToString
public class Session {
    @Id
    @GeneratedValue(strategy = AUTO)
    private String id;
    private String sessionId;
    private LocalDateTime timeout;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
