package Laba13;

import java.util.*;

class Company {
    private String name;
    private Employee director;
    private Map<String, Department> departments;

    public Company(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new HashMap<>();
    }

    public void addDepartment(Department department) {
        departments.put(department.getName(), department);
    }

    public Department getDepartment(String name) {
        return departments.get(name);
    }

    public Map<String, Department> getDepartments() {
        return departments;
    }
}
