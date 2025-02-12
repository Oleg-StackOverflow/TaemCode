package semester_1.Laba8;

class Manager extends Employee implements Managerial {
    private final int teamSize;

    public Manager(String name, int age, int teamSize) {
        super(name, age);
        this.teamSize = teamSize;
    }

    @Override
    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public String getRole() {
        return "Керівник";
    }

    @Override
    public String toString() {
        return super.toString() + ", Керівник{Розмір команди=" + teamSize + "}";
    }
}
