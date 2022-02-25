package pro.sky.course_2.interfaces;

import pro.sky.course_2.Employee;

public interface EmployeeService {

    Employee addEmployee(String lastName, String firstName);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);
}
