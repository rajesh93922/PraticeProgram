package com.java8StreamAndLambdaEmpStm3;

import java.util.List;
import java.util.stream.Stream;

public class EmployeeStreamAndLambda {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDatabase.getEmployees();
        Stream<Employee> employeeFinance =
                EmployeeUtility.getEmployeesByDepartment(
                        employeeList.stream(),"Finance");
       // employeeStream.forEach(System.out::println);

        Stream<Employee> employeeNewYork =
                EmployeeUtility.getEmployeesByLocation(
                        employeeList.stream(),"New York");
       // employeeNewYork.forEach(System.out::println);

        double minSalary = 60000, maxSalary = 80000;
        List<Employee> employeesInSalaryRange = EmployeeUtility
                .getEmployeesInSalaryRange(employeeList, minSalary, maxSalary);
        System.out.println(employeesInSalaryRange);

    }
}
