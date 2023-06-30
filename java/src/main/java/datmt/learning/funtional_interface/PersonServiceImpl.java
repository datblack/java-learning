package datmt.learning.funtional_interface;

import io.vavr.control.Validation;

public class PersonServiceImpl implements PersonService{

    public PersonServiceImpl() {
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public String getName() {
        return null;
    }

    public void hello() {
    }

    PersonFunc personFunc = System.out::println;

}
