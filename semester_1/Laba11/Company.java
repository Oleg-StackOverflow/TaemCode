package semester_1.Laba11;

import java.util.*;

class Company {
    private String name;
    private Employee director;
    private Set<Department> departments;

    public Company(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new TreeSet<>(new DepartmentComparator());
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public Employee getDirector() {
        return director;
    }

    public double findMaxSalary() {
        double maxSalary = director.getSalary();
        for (Department department : departments) {
            if (department.getManager().getSalary() > maxSalary) {
                maxSalary = department.getManager().getSalary();
            }
            for (Employee employee : department.getEmployees()) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                }
            }
        }
        return maxSalary;
    }

    public Set<String> findDepartmentsWithHigherPaidEmployees() {
        Set<String> result = new TreeSet<>();
        for (Department department : departments) {
            double managerSalary = department.getManager().getSalary();
            for (Employee employee : department.getEmployees()) {
                if (employee.getSalary() > managerSalary) {
                    result.add(department.getName());
                    break;
                }
            }
        }
        return result;
    }

    public Set<Employee> getAllEmployees() {
        Set<Employee> allEmployees = new TreeSet<>();
        allEmployees.add(director);
        for (Department department : departments) {
            allEmployees.add(department.getManager());
            allEmployees.addAll(department.getEmployees());
        }
        return allEmployees;
    }
}
