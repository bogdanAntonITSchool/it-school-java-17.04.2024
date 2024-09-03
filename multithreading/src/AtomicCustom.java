import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCustom {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running: " + atomicInteger.incrementAndGet());
            }
        };

        for (int i = 0; i < 5; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }
}
