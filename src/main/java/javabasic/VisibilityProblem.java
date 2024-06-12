package main.java.javabasic;

class SharedResource {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        flag = true;
        System.out.println("Flag set to true");
    }

    public void checkFlag() {
        while (!flag) {
//            System.out.println("1");
//            try {
//                Thread.sleep(11);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Flag is true");
    }
}

public class VisibilityProblem {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread writerThread = new Thread(resource::setFlagTrue);
        Thread readerThread = new Thread(resource::checkFlag);

        readerThread.start();
        Thread.sleep(100); // Ensure reader starts first
        writerThread.start();
    }
}
