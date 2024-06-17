package leteecode.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CombinationSum39 {
//    示例1：
//    输入：candidates = [2,3,6,7], target = 7
//    输出：[[2,2,3],[7]]
//    解释：
//            2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//            7 也是一个候选， 7 = 7 。
//    仅有这两种组合。
//
//    示例2：
//    输入: candidates = [2,3,5], arget = 8
//    输出: [[2,2,2,2],[2,3,3],[3,5]]
//
//    示例3：
//    输入: candidates = [2], target = 1
//    输出: []

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        dfs(lists, candidates, target, 0, new ArrayList<Integer>());
        return lists;
    }

    public void dfs(List<List<Integer>> res, int[] candidates, int target, int idx, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfs(res, candidates, target - candidates[i], i, tmp);
            tmp.remove(Integer.valueOf(candidates[i]));
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 6, 7};
//        int target = 7;
        int[] arr = {2, 3, 5};
        int target = 8;
//        int[] arr = {2};
//        int target = 1;
        System.out.println(new CombinationSum39().combinationSum(arr, target));
    }

    public List<List<Integer>> getRes(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }

        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i : arr) {
            int tmp = i;
            while (i <= target) {
                ArrayList<Integer> integers = new ArrayList<>();
                int t = i / tmp;
                while (t > 0) {
                    integers.add(tmp);
                    t--;
                }

                List<List<Integer>> orDefault = map.getOrDefault(i,
                        new ArrayList<List<Integer>>());
                orDefault.add(integers);
                map.put(i, orDefault);
                if (i == target) {
                    res.add(integers);
                }
                i += i;


            }
        }
        System.out.println(map.toString());
        for (int i : arr) {

            int remain = target - i;
            if (remain < i) {
                continue;
            }

            List<List<Integer>> orDefault = map.getOrDefault(remain, new ArrayList<List<Integer>>());
            if (!orDefault.isEmpty()) {
                for (List<Integer> l : orDefault) {
                    List<Integer> integers = new ArrayList<>(l);
                    integers.add(i);
                    res.add(integers);
                }
            }
        }

        return res;
    }
}
