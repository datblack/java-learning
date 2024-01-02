package datmt.learning.generic;

public class Employee extends Person{
    private String name;
    private Integer age;
    private Integer gender;
    private String birthDay;
    private Integer salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birthDay='" + birthDay + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee() {
    }

    public Employee(String name, Integer age, Integer gender, String birthDay, Integer salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthDay = birthDay;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
