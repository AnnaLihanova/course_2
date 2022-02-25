package pro.sky.course_2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_2.Employee;
import pro.sky.course_2.services.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        return employeeService.addEmployee(lastName, firstName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }
}
