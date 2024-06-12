package javabasic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LeCyclicBarrier {

    private  static int a =0;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("end " + a);
                a=0;
            }
        });

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                        System.out.println("finish one batch");
                        a++;
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                        System.out.println("finish one batch");
                        a++;
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                        System.out.println("finish one batch");
                        a++;
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }
}
