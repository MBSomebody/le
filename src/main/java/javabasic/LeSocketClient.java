package main.java.javabasic;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeSocketClient {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket localhost = new Socket("localhost", 6666);
                        OutputStream outputStream = localhost.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                        int i1 = new Random().nextInt();
                        String sendS = "hello from client " + i1;
                        bufferedWriter.write(sendS);
                        bufferedWriter.flush();
                        localhost.shutdownOutput();

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
                        System.out.println(bufferedReader.readLine() + "---" + sendS);
                        bufferedReader.close();
                        localhost.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        Thread.sleep(1000 * 60);
        System.out.println("end");

    }


}
