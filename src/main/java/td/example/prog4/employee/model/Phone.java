package td.example.prog4.employee.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Phone implements Serializable {
    private String id;
    private String value;
    private String countryCode;
}
