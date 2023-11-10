package employees;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@Slf4j
public class EmployeesController {

    private EmployeesClient employeesClient;

    @GetMapping("/employees")
    public ModelAndView listEmployees(Principal principal) {
        log.debug("Principal: {}", principal);
        Map<String, Object> model = new HashMap<>();
        // Mivel ez áthív, és a WebClient miatt authentikálni kell, ezért automatikusan bejelentkeztet a listázásnál is
       model.put("employees", employeesClient.listEmployees());
        model.put("command", new Employee());

        return new ModelAndView("employees", model);
    }

    @GetMapping("/create-employee")
    public ModelAndView createEmployee(Principal principal) {
        log.info("Logged in user: {}", principal.getName());
        var model = Map.of(
                "command", new Employee()
        );
        return new ModelAndView("create-employee", model);
    }

    @PostMapping("/create-employee")
    public ModelAndView createEmployeePost(@ModelAttribute Employee command) {
        employeesClient.createEmployee(command);
        return new ModelAndView("redirect:/employees");
    }

}