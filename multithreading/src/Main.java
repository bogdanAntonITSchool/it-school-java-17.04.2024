public class Main {
    public static void main(String[] args) throws InterruptedException {
//        CustomThread customThread = new CustomThread("t1");
//        customThread.start();
//
//        CustomThread customThread2 = new CustomThread("t2");
//        customThread2.start();
//
//        CustomThread customThread3 = new CustomThread("t3");
//        customThread3.start();

        Thread thread = new Thread(() -> {
            long l = System.currentTimeMillis();

            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + l + " is running: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread.sleep(1000);

        Thread thread2 = new Thread(() -> {
            long l = System.currentTimeMillis();

            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + l + " is running: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        thread2.join();
        System.out.println("Main thread is running");
    }
}

// thread starts first
// thread2 starts after 1s
// thread finishes first
// thread2 joins main thread after it finishes
// main thread starts after thread2 finishes

class CustomThread extends Thread {

    private final String name;

    CustomThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + name + " is running: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}