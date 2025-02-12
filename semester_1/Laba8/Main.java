package semester_1.Laba8;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Іван", 30);
        Manager mgr = new Manager("Марія", 40, 5);

        Displayable display = new ConsoleDisplay();
        display.displayInfo(emp);
        display.displayInfo(mgr);

        Employee emp2 = new Employee("Іван", 30);
        System.out.println("emp.equals(emp2): " + emp.equals(emp2));
    }
}