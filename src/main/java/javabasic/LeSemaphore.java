package main.java.javabasic;

import java.util.concurrent.Semaphore;

public class LeSemaphore {
    private static int a = 0;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphore.acquire();
                        Thread.sleep(100);
                        a++;
                        System.out.println("finish a batch " + currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphore.acquire();
                        Thread.sleep(100);
                        a++;
                        System.out.println("finish a batch " + currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphore.acquire();
                        Thread.sleep(100);
                        a++;
                        System.out.println("finish a batch " + currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                    semaphore.release();
                    semaphore.release();
                    System.out.println("c 1" + currentThread());
                }
            }
        }.start();
    }
}
