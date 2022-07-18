package newCaseStudy.model.person;

import java.util.List;

public class Employee extends Person{
    private String level, workLocation;
    private double salary;

    public Employee(int id, int idCard, int phoneNumber, String name, String birthDay, String gender, String email, String level, String workLocation, double salary) {
        super(id, idCard, phoneNumber, name, birthDay, gender, email);
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +super.toString()+'\''+
                "level='" + level + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
