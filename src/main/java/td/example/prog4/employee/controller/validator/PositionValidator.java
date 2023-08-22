package td.example.prog4.employee.controller.validator;

import td.example.prog4.employee.controller.validator.utils.StringValidator;
import td.example.prog4.employee.model.exception.BadRequestException;
import td.example.prog4.employee.repository.entity.Position;

public class PositionValidator {
    public void validate(Position position){
        StringBuilder error = new StringBuilder();

        if(StringValidator.isNotNullAndNotBlank(position.getName())){
            error.append("CnapsEmployeePosition name is mandatory");
        }

        if(!error.isEmpty()){
            throw new BadRequestException(error.toString());
        }
    }
}
