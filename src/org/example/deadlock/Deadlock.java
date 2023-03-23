package org.example.deadlock;

public class Deadlock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();
    public static Object lock3=  new Object();
    public static Object lock4=  new Object();
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
    }

    static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }

    static class Thread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
    static class Thread3 extends Thread{
        public void run(){
            synchronized (lock3){
                System.out.println("Thread 3:утка кря-кря");
                try {
                    Thread.sleep(1);
                }catch (InterruptedException e) {}
                System.out.println("Thread 3:гав-гав");

                synchronized (lock4) {
                    System.out.println("Thread 3:мяу-мяу");
                }
            }
        }
    }


}