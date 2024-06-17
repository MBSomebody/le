package leteecode.algo;

import java.util.Arrays;
import java.util.Comparator;

public class PaintWalls {

    public int paintWalls(int[] cost, int[] time) {
        int dp[][] = new int[cost.length][cost.length];

        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        return dfs(dp, cost, time, cost.length - 1, 0);

    }

    private int dfs(int[][] dp, int[] cost, int[] time, int i, int j) {

        if (j - i < 0) {
            return 0;
        }
        if (i < 0) {
            return Integer.MAX_VALUE;
        }

        int res = Math.min(dfs(dp, cost, time, i - 1, j + time[i]) + cost[i], dfs(dp, cost, time, i - 1, j - 1));
        dp[i][j] = res;
        return res;
    }


    public int paintWallsFail(int[] cost, int[] time) {
        int[][] arr = new int[cost.length][2];
        for (int i = 0; i < cost.length; i++) {
            arr[i][0] = cost[i];
            arr[i][1] = time[i];
        }
        return Math.min(m1(arr, cost), m2(arr, cost));
    }

    private int m1(int[][] arr, int[] cost) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                float res = o1[0] / (float) o1[1] - o2[0] / (float) o2[1];
                if (res > 0) {
                    return 1;
                } else if (res == 0) {
                    return o1[0] - o2[1];
                } else {
                    return -1;
                }
            }
        });
        System.out.println(Arrays.deepToString(arr));
        int l = 0, r = cost.length - 1;
        if (l == r) {
            return cost[0];
        }

        int res = 0;
        while (l <= r) {
            res += arr[l][0];
            int t = arr[l][1];
            while (r > 0 && t > 0) {
                r--;
                t--;
            }
            l++;
        }
        return res;
    }

    private int m2(int[][] arr, int[] cost) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(arr));
        int l = 0, r = cost.length - 1;
        if (l == r) {
            return cost[0];
        }

        int res = 0;
        while (l <= r) {
            res += arr[l][0];
            int t = arr[l][1];
            while (r > 0 && t > 0) {
                r--;
                t--;
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] c = {26, 53, 10, 24, 25, 20, 63, 51};
        int[] t = {1, 1, 1, 1, 2, 2, 2, 1};
        System.out.println(new PaintWalls().paintWalls(c, t));
    }
}
