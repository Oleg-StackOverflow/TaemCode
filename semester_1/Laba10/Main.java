package semester_1.Laba10;

public class Main {
    public static void main(String[] args) {

        Employee director = new Employee("Степан", "Бандера", 100000);
        Employee manager1 = new Employee("Богдан", "Буцик", 80000);
        Employee manager2 = new Employee("Олег", "Захаров", 85000);
        Employee emp1 = new Employee("Артем", "Христенок", 70000);
        Employee emp2 = new Employee("Микола", "Шейко", 90000);
        Employee emp3 = new Employee("Олександр", "Несміян", 60000);

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
        System.out.println("Список усіх працівників:");
        for (Employee employee : company.getAllEmployees()) {
            System.out.println(employee);
        }
    }
}