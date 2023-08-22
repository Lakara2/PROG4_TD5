package td.example.prog4.employee.model.utilities;

import lombok.Getter;
import td.example.prog4.employee.model.exception.BadRequestException;

public record PerPage(@Getter Integer perPage) {
    public static final int MAX_PER_PAGE = 500;

    public PerPage(Integer perPage) {
        if (perPage > MAX_PER_PAGE) {
            throw new BadRequestException("Page size must be < " + MAX_PER_PAGE);
        } else {
            this.perPage = perPage;
        }
    }
}
