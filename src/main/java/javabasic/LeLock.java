package main.java.javabasic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class LeLock {
//    private static AtomicInteger a = new AtomicInteger(0);
    private static int a =  0;

    public static void leLock(Lock lock) {
        lock.lock();
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
//        a.addAndGet(1);
        lock.unlock();
    }

    public static void  leReadWriteLock(ReadWriteLock lock){
        lock.writeLock().lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        lock.writeLock().unlock();

    }

    public static void leStampedLock(StampedLock lock) {
        long stmp = lock.writeLock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        lock.unlockWrite(stmp);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ReentrantLock reentrantLock = new ReentrantLock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        StampedLock stampedLock = new StampedLock();

        for (int i = 0; i < 99; i++) {
//            executorService.submit(() -> leLock(reentrantLock));
//            executorService.submit(() -> leReadWriteLock(readWriteLock));
            executorService.submit(() -> leStampedLock(stampedLock));
        }
        try {
            executorService.awaitTermination(5500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        executorService.shutdown();
    }
}
