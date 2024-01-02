package datmt.learning.collection.setstruct;

import java.util.Objects;

public class Person {
    private String name;
    private String cccd;

    public Person() {
    }

    public Person(String name, String cccd) {
        this.name = name;
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(cccd, person.cccd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cccd);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cccd='" + cccd + '\'' +
                '}' + "\n";
    }
}
