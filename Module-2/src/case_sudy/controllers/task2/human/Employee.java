package case_sudy.controllers.task2.human;

public class Employee extends Person{
    private String level;
    private String workLocation;
    private int salary;

    public Employee(int id, String name, String birthDay, String gender, int idCard, int phoneNumber, String email, String level, String workLocation, int salary) {
        super(id, name, birthDay, gender, idCard, phoneNumber, email);
        this.level = level;
        this.workLocation = workLocation;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String birthDay, String gender, int idCard, int phoneNumber, String email) {
        super(id, name, birthDay, gender, idCard, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + getLevel() + '\'' +
                ", workLocation='" + getWorkLocation() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}
