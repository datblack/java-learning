package datmt.learning.funtional_interface.example;

public class ServiceImpl implements Service{
    @Override
    public void calculating(Calculator calculator, int... ints) {
        System.out.println(calculator.apply(ints));
    }
}
