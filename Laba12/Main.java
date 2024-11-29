package Laba12;

public class Main {
    public static void main(String[] args) {
        Employee director = new Employee("D1", "Степан", "Бандера", 100000);
        Employee manager1 = new Employee("M1", "Богдан", "Буцик", 80000);
        Employee manager2 = new Employee("M2", "Олег", "Захаров", 85000);
        Employee emp1 = new Employee("E1", "Артем", "Христенок", 70000);
        Employee emp2 = new Employee("E2", "Микола", "Шейко", 90000);
        Employee emp3 = new Employee("E3", "Олександр", "Несміян", 60000);

        Department dept1 = new Department("IT", manager1);
        dept1.addEmployee(emp1);
        dept1.addEmployee(emp2);

        Department dept2 = new Department("HR", manager2);
        dept2.addEmployee(emp3);

        Company company = new Company("TechCorp", director);
        company.addDepartment(dept1);
        company.addDepartment(dept2);

        System.out.println("Максимальна заробітна платня: " + company.findMaxSalary());
        System.out.println("Відділи з працівниками, що отримують більше за начальника: " + company.findDepartmentsWithHigherPaidEmployees());
        System.out.println("Знайти працівника за ID (E2): " + company.findEmployeeById("E2"));
    }
}
