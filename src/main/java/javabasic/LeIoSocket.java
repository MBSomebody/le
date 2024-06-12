package javabasic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LeIoSocket {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(6667);
        Socket accept = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String s  = bufferedReader.readLine() ;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bufferedWriter.write("server ack\\n");
        bufferedWriter.flush();
        accept.shutdownOutput();
        System.out.println("----");
        Thread.sleep(10000);
        bufferedWriter.close();
        bufferedReader.close();
        accept.close();
    }
}
