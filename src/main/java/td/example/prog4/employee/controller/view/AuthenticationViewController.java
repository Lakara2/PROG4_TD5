package td.example.prog4.employee.controller.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import td.example.prog4.employee.repository.entity.User;

;

@Controller
@AllArgsConstructor
public class AuthenticationViewController {
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("credentials", User.builder().build());
        return "login";
    }
}
