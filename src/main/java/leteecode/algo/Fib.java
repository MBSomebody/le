package leteecode.algo;

import java.util.*;

public class Fib {

    public String decodeString(String s) {
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int t = Integer.parseInt(String.valueOf(c));

                StringBuilder stringBuilder1 = new StringBuilder();
                while (t > 0) {
                    stringBuilder1.append(stringBuilder);
                }
                stringBuilder = stringBuilder1;
            } else if (c == '[') {
                stringBuilder.append(decodeString(s.substring(i)));
            } else if (Character.isLetter(c)) {
                stringBuilder.append(c);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    int[] dp;

    public int fib(int n) {
        if (dp == null) {
            dp = new int[n + 1];
        }
        if (n == 0) {
            dp[0] = 0;
            return 0;
        }
        if (n == 1) {
            dp[1] = 1;
            return 1;
        }
        if (n == 2) {
            dp[2] = 1;
            return 1;
        }
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        int fib = new Fib().fib(4);
        System.out.println(fib);
    }
}
