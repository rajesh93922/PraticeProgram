package com.java8StreamAndLambdaEmpStm3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeUtility {
    public static Stream<Employee> getEmployeesByDepartment(Stream<Employee> employeeStream, String finance) {

        return employeeStream.filter(employee -> employee.getDepartment().equals(finance));
    }

    public static Stream<Employee> getEmployeesByLocation(Stream<Employee> employeeStream, String location) {
        return employeeStream.filter(employee -> employee.getLocation().equals(location));

    }

    public static List<Employee> getEmployeesInSalaryRange(
            List<Employee> employeeSalaryList, double minSalary, double maxSalary) {

        return employeeSalaryList.stream()
                .filter(employee -> employee.getSalary() >= minSalary
                        && employee.getSalary() <= maxSalary)
                .collect(Collectors.toList());

    }
}
