package td.example.prog4.employee.model.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ServerException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }
}
