package Laba10;

import java.util.*;

class Company {
    private String name;
    private Employee director;
    private List<Department> departments;

    public Company(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
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

    public List<String> findDepartmentsWithHigherPaidEmployees() {
        List<String> result = new ArrayList<>();
        for (Department department : departments) {
            double managerSalary = department.getManager().getSalary();
            for (Iterator it = department.getEmployees().iterator(); it.hasNext(); ) {
                Employee employee = (Employee) it.next();
                if (employee.getSalary() > managerSalary) {
                    result.add(department.getName());
                    break;
                }
            }
        }
        return result;
    }
    
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(director);
        Iterator<Department> deptIterator = departments.iterator();
        while (deptIterator.hasNext()) {
            Department department = deptIterator.next();
            allEmployees.add(department.getManager());
            Iterator<Employee> empIterator = department.getEmployees().iterator();
            while (empIterator.hasNext()) {
                allEmployees.add(empIterator.next());
            }
        }
        return allEmployees;
    }
}

