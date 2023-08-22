package td.example.prog4.cnaps.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "\"cnapsEmployee\"")
public class CnapsEmployee implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private String id;
    private String cin;
    private String cnaps;
    private String image;
    private String address;
    private String lastName;
    private String firstName;
    private String personalEmail;
    private String professionalEmail;
    private String registrationNumber;

    private LocalDate birthDate;
    private LocalDate entranceDate;
    private LocalDate departureDate;

    private Integer childrenNumber;

    private String endToendId;



   
}