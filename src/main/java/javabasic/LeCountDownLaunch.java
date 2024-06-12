package main.java.javabasic;

import java.util.concurrent.CountDownLatch;

public class LeCountDownLaunch {
    private static int a = 0;

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(2);

        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i<5) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a++;
                    System.out.println(" p +1" + count.getCount());
                    i++;
                    count.countDown();
                }
            }
        }.start();

        try {
            count.await();

//            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println("----");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println("----");

    }
}
