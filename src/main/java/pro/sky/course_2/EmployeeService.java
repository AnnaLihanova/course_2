package pro.sky.course_2;

import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    static Employee[] employees = {
            new Employee("Ivanov", "Ivan"),
            null,
            new Employee("Шариков", "Роман"),
            new Employee("Дудник", "Петр"),
            new Employee("Кромкина", "Мария"),
            new Employee("Тарасова", "Татьяна"),
    };

    public Employee addEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(newEmployee)) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return newEmployee;
            }
        }
        throw new ArrayOverflowException("Employee can't be added. Array is full");
    }

    public Employee removeEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(newEmployee)) {
                employees[i] = null;
                return null;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public Employee findEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(newEmployee)) {
                return employees[i];
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
}

