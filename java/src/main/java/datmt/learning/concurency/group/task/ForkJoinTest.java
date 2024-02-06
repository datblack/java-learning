package datmt.learning.concurency.group.task;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class ForkJoinTest {
    public static void main(String[] args) {
        List<Integer> arrInt = List.of(1, 2, 3, 2, 5, 6, 7, 2, 9, 10);
        Counter counter = new Counter(arrInt, 0, arrInt.size(),integer -> integer == 2);
        var pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

class Counter extends RecursiveTask<Integer> {
    public  static final int THRESHOLD = 5;
    private final List<Integer> numbers;
    private final int start;
    private final int end;
    private final Predicate<Integer> predicate;


    public Counter(List<Integer> numbers, int start, int end, Predicate<Integer> predicate) {
        this.numbers = numbers;
        this.predicate = predicate;
        this.end = end;
        this.start = start;
    }

    @Override
    protected Integer compute() {
        if (end - start < THRESHOLD) {
            int count = 0;
            for (int i = start; i < end; i++) {
                if (predicate.test(numbers.get(i))) count++;
            }
            return count;
        } else {
            int mid = (start + end) / 2;
            var leftSide = new Counter(numbers, start, mid, predicate);
            var rightSide = new Counter(numbers, mid, end, predicate);
            leftSide.fork();
            rightSide.fork();
            return leftSide.join() + rightSide.join();
        }
    }
}
