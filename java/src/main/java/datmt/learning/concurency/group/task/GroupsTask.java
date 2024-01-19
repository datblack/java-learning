package datmt.learning.concurency.group.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupsTask {
    /**
     * Đếm số lần xuất hiện của một từ nhất định trong một tập tin
     */
    public static long occurrences(String word, Path path) {
        try (var in = new Scanner(path)) {
            int count = 0;
            while (in.hasNext())
                if (in.next().equals(word)) count++;
            return count;
        } catch (IOException exception) {
            return 0;
        }
    }

    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.filter(Files::isRegularFile).collect(Collectors.toSet());
        }
    }

    /**
     * Cung cấp tác vụ tìm kiếm một từ trong một file
     */
    public static Callable<Path> searchForTask(String word, Path path) {
        return () -> {
            try (var in = new Scanner(path)) {
                while (in.hasNext()) {
                    if (in.next().equals(word)) return path;
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Search in " + path + "cancel");
                        return null;
                    }
                }
                System.out.println("No element found !");
                return null;
            }
        };
    }


    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory: ");
            String start = in.nextLine();
            System.out.print("Enter key word for search: ");
            String word = in.nextLine();

            Set<Path> files = descendants(Path.of(start));
            var countTasks = new ArrayList<Callable<Long>>();
            for (Path file : files) {
                Callable<Long> task = () -> occurrences(word, file);
                countTasks.add(task);
            }

            ExecutorService executor = Executors.newFixedThreadPool(4);
            Instant startTime = Instant.now();
            try {
                List<Future<Long>> results = executor.invokeAll(countTasks);
                long total = 0;
                for (Future<Long> result : results) {
                    total += result.get();
                }
                Instant endTime = Instant.now();

                System.out.println("Occurrences of " + word + ": " + total);
                System.out.println("Time elapsed: " + Duration.between(startTime, endTime).toMillis() + " millisecond");

                var searchTasks = new ArrayList<Callable<Path>>();
                for (Path file : files) {
                    searchTasks.add(searchForTask(word, file));
                    Path found = executor.invokeAny(searchTasks);
                    System.out.println(word + " occurs in: " + found);
                    if (executor instanceof ThreadPoolExecutor) {
                        System.out.println("Largest pool size: " + ((ThreadPoolExecutor) executor).getLargestPoolSize());
                    }
                }
            } finally {
                executor.shutdown();
            }
        }
    }
}
