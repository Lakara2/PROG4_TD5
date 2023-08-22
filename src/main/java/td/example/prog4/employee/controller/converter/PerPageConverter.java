package td.example.prog4.employee.controller.converter;

import org.springframework.core.convert.converter.Converter;
import td.example.prog4.employee.model.utilities.PerPage;

public class PerPageConverter implements Converter<String, PerPage> {
    @Override
    public PerPage convert(String source) {
        return new PerPage(Integer.valueOf(source));
    }
}
