package case_sudy.models.person;

public class Employee extends Person{
    private String level;
    private String workLocation;
    private double salary;

    public Employee(int id, String name, String birthDay, String gender, int idCard, int phoneNumber, String email, String level, String workLocation, double salary) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

    @Override
    public String toString() {
        return "Employee{"+super.toString()+
                "\nlevel='" + getLevel() + '\'' +
                ", workLocation='" + getWorkLocation() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}
