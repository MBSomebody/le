package javabasic;

import java.io.*;
import java.util.Scanner;

public class LeIo {
    public static void main(String[] args) throws Exception {

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        System.out.println(s);

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String s = bufferedReader.readLine();
////        System.out.println(s);
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        bufferedWriter.write(s);
//        bufferedWriter.close();
//        bufferedReader.close();

        Class<LeIo> leIoClass = LeIo.class;
        String classPath = leIoClass.getResource("").getPath();

        System.out.println(classPath);
        File f = new File("/Users/pengfeng/Documents/lcloud/myclient/target/classes/ryan/cloud/myclient/a.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
//        System.out.println(bufferedReader.readLine());
        File f2 = new File("/Users/pengfeng/Documents/lcloud/myclient/target/classes/ryan/cloud/myclient/b.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f2));
        bufferedWriter.write(bufferedReader.readLine());
        bufferedWriter.close();
        bufferedReader.close();


    }
}
