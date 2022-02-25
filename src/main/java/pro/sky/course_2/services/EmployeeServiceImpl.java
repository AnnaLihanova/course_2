package pro.sky.course_2.services;

import org.springframework.stereotype.Service;
import pro.sky.course_2.data.Employee;
import pro.sky.course_2.interfaces.EmployeeService;
import pro.sky.course_2.exceptions.EmployeeAlreadyAddedException;
import pro.sky.course_2.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivanov", "Ivan"),
            new Employee("Шариков", "Роман"),
            new Employee("Дудник", "Петр"),
            new Employee("Кромкина", "Мария"),
            new Employee("Тарасова", "Татьяна")
    ));

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(newEmployee)) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            }
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee removeEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(removeEmployee)) {
                employees.remove(removeEmployee);
                return removeEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public boolean findEmployee(String lastName, String firstName) {
        Employee findEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(findEmployee)) {
                return true;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public List<Employee> printListOfEmployee() {
        return employees;
    }
}

