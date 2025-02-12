package semester_1.Laba13;

public class Main {
    public static void main(String[] args) {
        try {
            Employee director = new Employee("Степан", "Бандера", 100000);
            Employee manager1 = new Employee("Богдан", "Буцик", 80000);
            Employee manager2 = new Employee("Олег", "Захаров", 85000);
            Employee emp1 = new Employee("Артем", "Христенок", 70000);
            Employee emp2 = new Employee("Микола", "Шейко", 90000);
            Employee emp3 = new Employee("Олександр", "Несміян", 60000);

            Department dept1 = new Department("IT", manager1, 4);
            Department dept2 = new Department("HR", manager2, 1);

            dept1.addEmployee(emp1);
            dept1.addEmployee(emp2);
            dept1.addEmployee(emp3);

            Company company = new Company("TechCorp", director);
            company.addDepartment(dept1);
            company.addDepartment(dept2);

        } catch (MaxEmployeesException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Некоректні дані: " + e.getMessage());
        } finally {
            System.out.println("Завершення програми.");
        }
    }
}
