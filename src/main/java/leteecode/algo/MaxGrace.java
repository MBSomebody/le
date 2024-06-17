package leteecode.algo;

import java.util.*;
import java.util.stream.Stream;

public class MaxGrace {
    public long findMaximumElegance(int[][] items, int k) {
        if (items == null || items.length == 0) {
            return 0;
        }

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(items));
        int f = items.length - k;
        int t = items.length - 1;
        int res = 0;
        Map<Integer, Integer> s = new HashMap<>();
        Set<Integer> useIndex = new HashSet<>();
        for (int i = f; i <= t; i++) {
            s.put(items[i][1], s.getOrDefault(items[i][1], 0) + 1);
            res += items[i][0];
            useIndex.add(i);
        }
        res += s.size() * s.size();

        if (s.size() == k) {
            return res;
        }

        System.out.println(res);
        for (int i = f - 1; i >= 0; i--) {
            int cat = items[i][1];
            int pft = items[i][0];
            if (s.containsKey(cat)) {
                continue;
            } else {
                for (int j = i; j <= t; j++) {
                    int jcnt = s.getOrDefault(items[j][1], 0);
                    if (jcnt > 1 && useIndex.contains(j)) {
                        int tmp = res - items[j][0] - s.size() * s.size() + pft + (s.size() + 1) * (s.size() + 1);
                        if (tmp > res) {
                            s.put(cat, 1);
                            useIndex.add(i);
                            s.put(items[j][1], s.get(items[j][1]) - 1);
                            useIndex.remove(j);
                            res = tmp;
                            break;
                        }
                    }
                }
            }
        }

        return res;

    }


    public static void main(String[] args) {
        int[][] a = {{3, 1}, {4, 2}, {9, 4}, {4, 4}, {7, 4}};
        System.out.println(new MaxGrace().findMaximumElegance(a, 2));
    }

}
