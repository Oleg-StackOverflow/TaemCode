package semester_1.Laba8;

class ConsoleDisplay implements Displayable {
    @Override
    public void displayInfo(Employee employee) {
        System.out.println(employee.toString());
        if (employee instanceof Managerial) {
            Managerial manager = (Managerial) employee;
            System.out.println("Роль: " + manager.getRole());
            System.out.println("Розмір команди: " + manager.getTeamSize());
        }
    }
}