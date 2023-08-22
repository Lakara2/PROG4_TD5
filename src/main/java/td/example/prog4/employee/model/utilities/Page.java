package td.example.prog4.employee.model.utilities;

import lombok.Getter;
import td.example.prog4.employee.model.exception.BadRequestException;

public record Page(@Getter Integer page) {
    public Page(Integer page) {
        if (page < 1) {
            throw new BadRequestException("Page cannot be < 1");
        } else {
            this.page = page - 1;
        }
    }
}
