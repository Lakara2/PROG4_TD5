package td.example.prog4.employee.controller.mapper;

import org.springframework.stereotype.Component;
import td.example.prog4.employee.repository.entity.enums.Sex;

@Component
public class SexMapper {
    public Sex toDomain(String sex){
        try {
            return Sex.valueOf(sex);
        } catch (IllegalArgumentException e){
            return null;
        }
    }
}
