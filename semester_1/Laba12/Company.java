package semester_1.Laba12;

import java.util.*;

class Company {
    private String name;
    private Employee director;
    private Set<Department> departments;
    private Map<String, Employee> employeeMap; // Для швидкого пошуку співробітників за ID

    public Company(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new HashSet<>();
        this.employeeMap = new HashMap<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
        // Додати співробітників відділу до Map
        employeeMap.put(department.getManager().getId(), department.getManager());
        for (Employee employee : department.getEmployees()) {
            employeeMap.put(employee.getId(), employee);
        }
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
        Set<String> result = new HashSet<>();
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

    public Employee findEmployeeById(String id) {
        return employeeMap.get(id);
    }
}
