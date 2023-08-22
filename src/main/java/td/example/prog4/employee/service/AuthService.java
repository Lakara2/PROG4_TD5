package td.example.prog4.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import td.example.prog4.employee.model.exception.ForbiddenException;
import td.example.prog4.employee.repository.SessionRepository;
import td.example.prog4.employee.repository.UserRepository;
import td.example.prog4.employee.repository.entity.Session;
import td.example.prog4.employee.repository.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    private static final Integer AUTHENTICATION_DURATION = 3_600;

    public void authenticateUser(User user, String sessionId) {
        Optional<User> currentUser = userRepository.findOneByUsername(user.getUsername());

        if (currentUser.isEmpty()) {
            throw new ForbiddenException("Please verify your credentials.");
        }
        if (!currentUser.get().getPassword().equals(user.getPassword())) {
            throw new ForbiddenException("Please verify your credentials.");
        }
        sessionRepository.save(Session.builder().sessionId(sessionId).user(currentUser.get()).timeout(LocalDateTime.now().plusSeconds(AUTHENTICATION_DURATION)).build());
    }

    public void verifySession(String sessionId){
        Optional<Session> session = sessionRepository.findOneBySessionId(sessionId);
        if(session.isEmpty() || session.get().getTimeout().isBefore(LocalDateTime.now())){
            throw new ForbiddenException("CnapsEmployeeSession expired.");
        }
    }

    public void removeSession(String sessionId){
        List<Session> sessions = sessionRepository.findAllBySessionId(sessionId);
        List<Session> sessionList = sessions.stream().peek(session -> session.setTimeout(LocalDateTime.now().minusSeconds(1))).toList();
        sessionRepository.saveAll(sessionList);
    }
}
