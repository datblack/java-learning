package datmt.learning.funtional_interface;

@FunctionalInterface
public interface Function<T> {
    T execute(T t);
}
