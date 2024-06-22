package leteecode.algo;

import java.util.HashSet;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        HashSet<Integer> integers = new HashSet<>();
        for (int i : nums
        ) {
            integers.add(i);
        }

        for (int i : integers) {

            if (!integers.contains(i - 1)) {
                int j = i;
                while (integers.contains(j)) {
                    j++;
                }
                res = Math.max(res,j-i);

            }
        }

        return res;

    }
}
