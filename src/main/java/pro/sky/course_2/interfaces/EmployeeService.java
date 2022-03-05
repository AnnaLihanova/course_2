package pro.sky.course_2.interfaces;

import pro.sky.course_2.data.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(String lastName, String firstName);

    public Employee removeEmployee(String lastName, String firstName);

    public boolean findEmployee(String lastName, String firstName);

    public List<Employee> printListOfEmployee();
}
