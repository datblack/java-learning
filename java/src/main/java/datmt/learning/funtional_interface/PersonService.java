package datmt.learning.funtional_interface;

public interface PersonService {
    void print(String s);
    String getName();
    @FunctionalInterface
    interface PersonFunc {
        void func(String s);
    }
}
