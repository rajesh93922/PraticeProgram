package com.java8StreamAndLambdaEmpStm3;

public class Employee {
    private String name;
    private String department;
    private String location;
    private double salary;
    private int experience;

    public Employee() {}

    public Employee(String name, String department, String location, double salary, int experience) {
        this.name = name;
        this.department = department;
        this.location = location;
        this.salary = salary;
        this.experience = experience;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getLocation() { return location; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setLocation(String location) { this.location = location; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setExperience(int experience) { this.experience = experience; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}

