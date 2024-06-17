package leteecode.algo;

import java.util.*;

public class MaxBeautyValue {

    public int maximumBeauty(int[] nums, int k) {
        int l = nums.length;
        int m = 0;
        for (int i : nums) {
            m = Math.max(m, i);
        }
        int[] df = new int[m + 2];

        for (int i : nums) {
            df[Math.max(0, i - k)]++;
            df[Math.min(i + k + 1, m + 1)]--;
        }

        int res = 0, count = 0;
        for (int i : df) {
            count += i;
            res = Math.max(res, count);
        }
        return res;
    }

    public int maximumBeauty2(int[] nums, int k) {

        Arrays.sort(nums);
        int res = 0;
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            while (i <= j && j < nums.length) {
                if (nums[j] - nums[i] > 2 * k) {
                    break;
                } else {
                    j++;
                }
            }
            res = Math.max(res, j - i);

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new MaxBeautyValue().maximumBeauty(new int[]{5, 57, 46}, 15));
    }
}
