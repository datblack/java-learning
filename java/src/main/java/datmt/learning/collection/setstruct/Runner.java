package datmt.learning.collection.setstruct;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person("Nguyen Van A", "0098776556"));
        people.add(new Person("Nguyen Van A", "00987765"));
        people.add(new Person("Nguyen Van A", "0098776556"));


        System.out.println(people);
    }
}
