package leteecode.algo;

public class MaxScore {
    public long maxScore(int[] nums, int x) {

        int res = 0;
        int[] dp = {Integer.MIN_VALUE,Integer.MIN_VALUE};
        dp[nums[0]%2] =  nums[0];

        for (int i = 1; i < nums.length ; i++) {
            int f = nums[i]%2;
            int a =Integer.MIN_VALUE;
            int b =Integer.MIN_VALUE;
            if (f ==0){
                a = dp[0] +nums[i];
                b = dp[1]  - x;
            }else {
                a = dp[0] -x;
                b = dp[1] +nums[i];
            }
            dp[0] = a;
            dp[1] =b;
            res =Math.max(Math.max(a,b),res);
        }
        return res;

    }
}
