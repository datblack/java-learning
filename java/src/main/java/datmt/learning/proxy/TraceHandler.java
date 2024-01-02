package datmt.learning.proxy;

import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Class này sẽ bao bọc một đối tượng
 */
public class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object t) {
        target = t;
    }

    public void print(){
        System.out.println("Object call");
    }

    /**
     * VD: ta dùng phương thức này để gọi in ra các tên và tham số của method cần được gọi (method của đối tượng được
     * bao bọc) và gọi phương thức của đối tượng dưới dạng ẩn tham số
     */
    @Override
    public Object invoke(Object proxy, // proxy của lớp handler
                         Method method,// method được gọi
                         Object[] args // tham số của method
    ) throws Throwable {
        System.out.println(method.getName());
        return method.invoke(target, args);// method gốc được gọi.
    }
}
