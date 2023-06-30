package datmt.learning.funtional_interface;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        var plusImpl = new PlusImpl(10, 20);
        System.out.println(plusImpl.tongNo((a, b) -> a + b));
        var abc = (PlusFI) (a1, a2) -> {
            System.out.println("1232");
            return 2;
        };
        System.out.println("====================");
        new Sys().plus(2,3);

    }
}
class Main2{
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();

        var a = new PersonServiceImpl();
        a.print("lskadhflkashdf");
        a.hello();
//        System.out.println(new Sys().function4.apply(1).apply(2.3).apply(new Person()));
    }
}

class FunctionTry{
    public static void main(String[] args) {
//        Try<Integer> integers = Try.of();
        var arr = new ArrayList<>(List.of(new Person(), new Person()));
        arr.sort(comparingInt(Person::getAge));
    }
}