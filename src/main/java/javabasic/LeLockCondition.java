package main.java.javabasic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer {
    private Queue<Integer> q = new LinkedList<>();
    private Integer Max_V = 10;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            if (q.size() < Max_V) {
                q.offer(1);
                System.out.println("p 1");
                notEmpty.signal();
            } else {
                try {
                    System.out.println("p w");
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {

            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            if (q.isEmpty()) {
                try {
                    System.out.println("c w");
                    notEmpty.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("c 1");
                q.remove();
                notFull.signal();
            }
        } finally {

            lock.unlock();
        }

    }
}

public class LeLockCondition {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Buffer buffer = new Buffer();
        Runnable p = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    buffer.produce();
                }
            }
        };
        Runnable c = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    buffer.consume();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        executorService.submit(p);
        executorService.submit(p);
        executorService.submit(p);
        executorService.submit(p);
        executorService.submit(p);
        executorService.submit(c);
        executorService.submit(c);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("----");

    }
}
