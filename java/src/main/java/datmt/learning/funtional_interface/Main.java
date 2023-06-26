package datmt.learning.funtional_interface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var plusImpl = new PlusImpl(10, 20);
        System.out.println(plusImpl.tongNo((a, b) -> a + b));
    }

}
