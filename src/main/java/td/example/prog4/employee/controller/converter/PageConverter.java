package td.example.prog4.employee.controller.converter;

import org.springframework.core.convert.converter.Converter;
import td.example.prog4.employee.model.utilities.Page;

public class PageConverter implements Converter<String, Page> {
    @Override
    public Page convert(String source) {
        return new Page(Integer.valueOf(source));
    }
}
