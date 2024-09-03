import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCustom {

    public static void main(String[] args) throws InterruptedException {

        try (ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,
                        4,
                        5,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(2))) {

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

            threadPoolExecutor.submit(runnable);
            Thread.sleep(1000);
            threadPoolExecutor.submit(runnable);
            Thread.sleep(1000);
            threadPoolExecutor.submit(runnable);
            threadPoolExecutor.submit(runnable);
            threadPoolExecutor.submit(runnable);
            threadPoolExecutor.submit(runnable);

            threadPoolExecutor.shutdown();
        }


    }
}
