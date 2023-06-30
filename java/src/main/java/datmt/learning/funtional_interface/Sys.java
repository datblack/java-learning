package datmt.learning.funtional_interface;

import io.vavr.Function0;
import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.Function4;
import io.vavr.control.Try;

import java.util.Objects;
import java.util.function.Function;

public class Sys {
    public int plus(int a, int b) {
        Function2<Integer, Integer, Integer> function2 = Integer::sum;
        return function2.apply(a, b);
    }

    static Function<String, String> function = s -> {
        System.out.println(s);
        return s;
    };

    public Function3<Integer, Double, Person, PersonRes> function4 = (integer, integer2, integer3) -> {
        System.out.println(integer);
        System.out.println(integer2);
        System.out.println(integer3);
        return new PersonRes("name",20);
    };


}
