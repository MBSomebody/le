package javabasic;

import java.util.TreeMap;

public class LeVolatile {

    private static boolean f = false;

    public static void main(String[] args) {


        new Thread(){
            @Override
            public void run() {
                while (true){
                System.out.println("read to " + f);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                f = true;
                System.out.println("change to " + f);
            }
        }.start();

        System.out.println("---");


    }
}
