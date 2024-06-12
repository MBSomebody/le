package main.java.javabasic;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PcFactory{

    private Queue<Integer> q = new LinkedList<Integer>();
    private Integer MAX_LEN = 10;

    public synchronized void produce(){
        if (q.size() >= MAX_LEN){
            try {
                System.out.println("p wait");
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("p 1");
            q.offer(1);
        }
    }
    public synchronized  void  consume(){
        if(q.isEmpty()){
            try {
                System.out.println("c wait");
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("c " + q.remove());
        }
    }

}
class Producer implements   Runnable{

    private PcFactory pc;

    public Producer(PcFactory pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        while (true){
            pc.produce();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements  Runnable{

    private PcFactory pc;

    public Consumer(PcFactory pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        while (true){
            pc.consume();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class LeProduceAndConsume2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService2 = Executors.newFixedThreadPool(9);

        PcFactory pc = new PcFactory();
        executorService.submit(new Producer(pc));

        executorService2.submit(new Consumer(pc));
        executorService2.submit(new Consumer(pc));
        executorService2.submit(new Consumer(pc));


        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        executorService2.shutdown();
        System.out.println("---");
    }
}
