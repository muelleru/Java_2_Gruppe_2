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
            for (int i = 0; i < count ; i++) {
                System.out.print(text);
                try {
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

    @Override
    public void doWork() {
            Thread t1 = new Thread( ()-> {
                for (int i = 0; i <1000 ; i++) {
                    System.out.print("A");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("INTERRUPT");
                    }
                }
            });


    }
}
