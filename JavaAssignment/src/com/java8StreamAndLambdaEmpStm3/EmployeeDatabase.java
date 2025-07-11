package com.java8StreamAndLambdaEmpStm3;

import java.util.Arrays;
import java.util.List;

public class EmployeeDatabase {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("John Doe", "Finance", "New York", 75000, 5),
                new Employee("Jane Smith", "HR", "Los Angeles", 60000, 3),
                new Employee("Michael Johnson", "Engineering", "San Francisco", 90000, 7),
                new Employee("Emily Davis", "Finance", "Chicago", 72000, 4),
                new Employee("Robert Brown", "HR", "New York", 58000, 2)
        );
    }
}
