package datmt.learning.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

/**
 * - Khi nào sử dụng Proxy ?
 * khi cần khởi tao một Object của một class implement một hoặc nhiều Interface một cách chính sác
 * nhưng bạn không biết tại thời điểm biên dịch (Thời điểm code). chúng ta có thể sử sụng newInstance của Proxy hoặc
 * reflection để khởi tọa Object đó. nhưng không thể khởi tạo Interface
 * - Mục đích của proxy là điều khiêển việc thực thi của một Object ban đầu khác bằng cách tạo môột lớp
 * bọc bên ngoài lớp gốc.
 * <p>
 * - Một số ứng dụng
 * - định tuyến các method gọi đến server
 * - Liên kết các sự kiện giao diện người dùng với các hành động trong chương trình chạy
 * - Tìm kiếm đến các method để phục vụ cho việc debug
 */
public class Runner {
    public static void main(String[] args) {
        /**
         * Để tạo một đối tượng proxy thì dùng newProxyInstance method của lớp Proxy
         * Method có 3 tham số
         * Proxy.newProxyInstance(
         *                     ClassLoader.getSystemClassLoader(),
         *                     new Class[]{Comparable.class}, // các interface thực thi
         *                     handler);
         * - class loader
         * - array của đối tượng Class
         * - một invocation handler hoặc một class implement interface InvocationHandler
         *  - trong đó có 1 method invoke: khi gọi các method trong một Object proxy thì method invoke sẽ được gọi
         *  sau đó trình sử lý xẽ tìm ra cách để gọi method của đối tượng.
         */

//        testProxy1();
//        testProxy2();
        testProxy3();
    }
    Predicate<Employee> predicate = func -> {

        return true;
    };
    private static void testProxy3() {

        PersonServiceImpl personService = new PersonServiceImpl();
        PersonService proxy = (PersonService) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {PersonService.class}, new TraceHandler(personService));
        proxy.print("hello proxy");
    }

    private static void testProxy2() {
        Map proxyMap = (Map) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Map.class}, new TimingDynamicInvocationHandler(new HashMap<>()));
        proxyMap.put("Name", "Val");
        System.out.println(proxyMap.toString());
    }

    /**
     * Test : in ra các bước thực hiện việc so sánh
     */
    public static void testProxy1() {

        var elements = new Object[1000];

        // fill elements with proxies for the integers 1 . . . 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[]{Comparable.class}, // các interface thực thi
                    handler);
            elements[i] = proxy;
        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;
        // search for the key
        int result = Arrays.binarySearch(elements, key);
        // print match if found
        if (result >= 0) System.out.println(elements[result]);
    }
}
