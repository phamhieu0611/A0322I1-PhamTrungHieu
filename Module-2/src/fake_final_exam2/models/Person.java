package fake_final_exam2.models;

public abstract class Person {
    private String name;
    private String date;
    private String gender;

    public abstract String layThongTin();

    public Person() {
    }

    public Person(String name, String date, String gender) {
        this.name = name;
        this.date = date;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
