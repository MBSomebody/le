package leteecode.algo;

import java.util.*;

public class SingSong {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        int cnt = Integer.parseInt(sc.nextLine().trim());
        int n = 0, x = 0, y = 0;
        while (sc.hasNextLine() && cnt > 0) {

            line = sc.nextLine().trim();
//            System.out.println(line);
            if (line.isEmpty()) {
                return;
            }
            String[] sa = line.split(" ");
            n = Integer.parseInt(sa[0]);
            x = Integer.parseInt(sa[1]);
            y = Integer.parseInt(sa[2]);

            int i = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            while (i < n) {
                int sm = sc.nextInt();
                while (sm > 0) {
                    int key = sc.nextInt();
                    mp.put(key, mp.getOrDefault(key, 0) + 1);
                    sm--;
                }
                i++;
            }
            if (mp.keySet().size() > y) {
                System.out.println("NO");

            }
            for (int key : mp.keySet()) {
                int singTimes = (int) Math.ceil(mp.get(key) / (float) x);
                y -= singTimes;
                if (y < 0) {
                    System.out.println("NO");
                }
            }
            if (y >= 0) {
                System.out.println("YES");
            }

        }
    }
}