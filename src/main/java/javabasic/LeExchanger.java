package main.java.javabasic;

import java.util.concurrent.Exchanger;

public class LeExchanger {

    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();

        new Thread("one thread"){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        String one_ok = stringExchanger.exchange("one ok");
                        System.out.println(currentThread() + " get " +one_ok);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("two thread"){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        String one_ok = stringExchanger.exchange("2 ok");
                        System.out.println(currentThread() + " get " +one_ok);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
