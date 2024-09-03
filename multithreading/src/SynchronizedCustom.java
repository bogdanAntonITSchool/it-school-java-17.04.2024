import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedCustom {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Integer> elements = new ArrayList<>();

        ReentrantLock lock = new ReentrantLock();

        Runnable runnable = () -> {
//            synchronized (elements) {
//                elements.add(10);
//            }
            boolean isAvailable = lock.tryLock();
            if (isAvailable) {
                elements.add(10);
                lock.unlock();
            }
        };
        Runnable readRunnable = () -> {
//            synchronized (elements) {
//                System.out.println(elements);
//            }
            boolean isAvailable = lock.tryLock();
            if (isAvailable) {
                System.out.println(elements);
                lock.unlock();
            }
        };

        for (int i = 0; i < 5; i++) {
            executorService.submit(runnable);
            executorService.submit(readRunnable);
        }
    }
}
