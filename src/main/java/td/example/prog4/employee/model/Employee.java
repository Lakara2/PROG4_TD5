package td.example.prog4.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import td.example.prog4.employee.repository.entity.Position;
import td.example.prog4.employee.repository.entity.enums.Csp;
import td.example.prog4.employee.repository.entity.enums.Sex;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Employee implements Serializable {
    private String id;
    private String firstName;
    private String lastName;

    private MultipartFile image;
    private String stringImage;

    private Csp csp;
    private Sex sex;
    private String cin;
    @Transient
    private String cnaps;
    private String address;
    private Integer childrenNumber;
    private String personalEmail;
    private String professionalEmail;
    private String registrationNumber;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate entranceDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate departureDate;

    private List<Position> positions;
    private List<Phone> phones;
    private String endToEndId;

}
