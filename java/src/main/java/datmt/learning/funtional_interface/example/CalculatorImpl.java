package datmt.learning.funtional_interface.example;

import java.util.Arrays;

public class CalculatorImpl implements Calculator{
    @Override
    public double apply(int... i) {
        return 0.1 * Arrays.stream(i).count();
    }
}
