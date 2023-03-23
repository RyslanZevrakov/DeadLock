package raceCondition;

public class RaceCondition {
    private static int count = 0;

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.println(count);
    }
}
