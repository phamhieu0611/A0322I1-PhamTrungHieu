package case_study.models.person;

public abstract class Person {
    private int id, idCard, phoneNumber;
    private String birthDay;
    private String name, gender, email;

    public Person(int id, int idCard, int phoneNumber, String name, String birthDay, String gender, String email) {
        this.id = id;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.email = email;
    }
    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                " , idCard=" + idCard +
                " , phoneNumber=" + phoneNumber +
                " , name='" + name + '\'' +
                " , birthDay='" + birthDay + '\'' +
                " , gender='" + gender + '\'' +
                " , email='" + email + '\'';
    }
}
