package Laba13;

import java.util.*;

class Department {
    private String name;
    private Employee manager;
    private Set<Employee> employees;
    private int maxEmployees;

    public Department(String name, Employee manager, int maxEmployees) {
        if (maxEmployees <= 0) {
            throw new IllegalArgumentException("Максимальна кількість працівників повинна бути більше нуля.");
        }
        this.name = name;
        this.manager = manager;
        this.maxEmployees = maxEmployees;
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

    public void addEmployee(Employee employee) throws MaxEmployeesException {
        if (employees.size() >= maxEmployees) {
            throw new MaxEmployeesException("Досягнуто максимальної кількості працівників у відділі: " + name);
        }
        employees.add(employee);
    }
}
