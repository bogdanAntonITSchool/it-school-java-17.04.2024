import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsCustom {

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            Runnable runnable = () -> {
                long l = System.currentTimeMillis();

                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread " + l + " is running: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            executorService.submit(runnable);
            Thread.sleep(1000);
            executorService.submit(runnable);
            Thread.sleep(1000);
            executorService.submit(runnable);

            executorService.shutdown();
        }
    }
}
