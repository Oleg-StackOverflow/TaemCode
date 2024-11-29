package Laba12;

import java.util.*;

class Department {
    private String name;
    private Employee manager;
    private Set<Employee> employees;

    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}