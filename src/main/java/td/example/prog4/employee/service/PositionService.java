package td.example.prog4.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import td.example.prog4.employee.repository.PositionRepository;
import td.example.prog4.employee.repository.entity.Position;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private PositionRepository repository;

    public List<Position> getAll(){
        return repository.findAll();
    }
    public Position saveOne(Position position){
        return repository.save(position);
    }
}
