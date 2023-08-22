package td.example.prog4.employee.controller.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import td.example.prog4.employee.model.Phone;
import td.example.prog4.employee.model.exception.BadRequestException;

@Component
@AllArgsConstructor
public class PhoneValidator {
    public void validate(Phone phone) {
        StringBuilder error = new StringBuilder();

        if (phone.getCountryCode() == null) {
            error.append("CnapsEmployeePhone's country code is mandatory. ");
        }
        
        if (phone.getValue() == null) {
            error.append("CnapsEmployeePhone's number is mandatory. ");
        } else if (phone.getValue().length() != 9) {
            error.append("CnapsEmployeePhone's number length must be = 9. ");
        } else if (phone.getValue().matches("[^0-9]")) {
            error.append("CnapsEmployeePhone's number must only contains digits. ");
        }

        if (phone.getCountryCode() == null) {
            error.append("CnapsEmployeePhone's country code is mandatory. ");
        } else if (phone.getCountryCode().length() < 1 || phone.getCountryCode().length() > 4) {
            error.append("CnapsEmployeePhone's country code length must be > 0 and < 5. ");
        } else if (phone.getCountryCode().matches("[^0-9]")) {
            error.append("CnapsEmployeePhone's country code must only contains digits. ");
        }

        if (!error.isEmpty()) {
            throw new BadRequestException(error.toString());
        }
    }
}
