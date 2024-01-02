package datmt.learning.generic;

public class Runner {
    public static void main(String[] args) {
        Pair<Employee> employee = new Pair<>();
        employee.setType(new Employee("Dat", 18, 0, "171371737", 90000));
        Pair<Manager> manager= new Pair<>();
        manager.setType(new Manager("Dat", 18, 0, "171371737", 100000, "trưởng phòng", 6.0));
        showDetail(employee);
        showDetail(manager);
    }

    public static void showDetail(Pair<? extends Employee> pair) {
        System.out.println(pair.showEntity().toString());
    }
}
