package threads;

import global.Workable;

public class Threads implements Workable {

    static class MyRunnable implements Runnable {
        private int sleep;
        private int count;
        private String text;

        public MyRunnable(int sleep, int count, String text) {
            this.sleep = sleep;
            this.count = count;
            this.text = text;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                try {
                    synchronized (ampel) {
                        System.out.print(text);
                        Thread.sleep(sleep);
                        System.out.print(text);
                        Thread.sleep(sleep);
                        System.out.println(text);

                    }
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("INTERRUPT");
                }
            }
        }
    }

    @Override
    public boolean isActive() {
        return true;
    }

    static Object ampel = new Object();

    @Override
    public void doWork() {

    }

    public void test1() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    // Semaphore nach Dijkstra
                    synchronized (ampel) {
                        System.out.print("A");
                        Thread.sleep(10);
                        System.out.print("A");
                        Thread.sleep(10);
                        System.out.println("A");
                    }
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("INTERRUPT");
                    break;
                }
            }
        });
        Thread t2 = new Thread(new MyRunnable(20, 50, "B"));
        Thread t3 = new Thread(new MyRunnable(100, 10, "C"));
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000);
            t1.interrupt();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("JOIN INTERRUPTED");
        }
        System.out.println("ENDE");
    }
}
