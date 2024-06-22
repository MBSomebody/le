package leteecode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int mi = intervals[i][0];
            int ma = intervals[i][1];

            int j = i + 1;
            while (j < intervals.length) {
                if (intervals[j][0] <= ma) {
                    ma = Math.max(intervals[j][1],ma);
                    j++;
                } else {
                    break;
                }
            }
            i = Math.max(i, j - 1);
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(mi);
            integers.add(ma);
            res.add(integers);

        }
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i).stream().mapToInt(Integer::valueOf).toArray();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] p = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] p = {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(p)));
    }
}
