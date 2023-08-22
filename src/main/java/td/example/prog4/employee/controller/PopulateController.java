package td.example.prog4.employee.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import td.example.prog4.employee.config.CompanyConf;

@Controller
public class PopulateController {


    @ModelAttribute("companyConf")
    private CompanyConf populateCompanyConf(){
        return new CompanyConf();
    }
}