package datmt.learning.funtional_interface;

public record PersonRes(String name,int age) {
    public PersonRes(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
