package semester_1.Laba13;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        if (firstName == null || lastName == null) {
            throw new NullPointerException("Ім'я або прізвище не можуть бути null.");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не може бути негативною.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Зарплата: " + salary + ")";
    }
}
