package main.java.javabasic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LeProducerAndConsumer {

    private static Queue<Integer> q = new LinkedList<Integer>();
    private static Integer MAX_LEN = 5;

    public static synchronized void produce(Lock plock, Lock cLock)  {
        if (q.size() < MAX_LEN) {
            Random random = new Random();
            int i = random.nextInt(5);
            q.offer(i);
            System.out.print("p "+ i);
            System.out.println(q.toString());
        }
        else {
            try {
                System.out.println("p wait");
                plock.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cLock.notifyAll();
        }
    }

    public static synchronized void consume(Lock pLock, Lock cLock) {

        if (q.isEmpty()){
            try {
                System.out.println("c wait");
                cLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pLock.notifyAll();
        }else{System.out.print(q.toString());

            System.out.println("c "+ q.remove());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ReentrantLock pLock = new ReentrantLock();
        ReentrantLock cLock = new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            executorService.submit(()->produce(pLock,cLock));
            executorService.submit(()->produce(pLock,cLock));
            executorService.submit(()->produce(pLock,cLock));
            executorService.submit(()->produce(pLock,cLock));
            executorService.submit(()->consume(pLock,cLock));
//            executorService.submit(()->consume(pLock,cLock));
        }
        executorService.shutdown();
    }
}
