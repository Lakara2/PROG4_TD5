package td.example.prog4.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import td.example.prog4.employee.repository.PhoneRepository;
import td.example.prog4.employee.repository.entity.Phone;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneService {
    private PhoneRepository repository;

    public List<Phone> getAll(){
        return repository.findAll();
    }

    public Phone saveOne(Phone position){
        return repository.save(position);
    }
}
