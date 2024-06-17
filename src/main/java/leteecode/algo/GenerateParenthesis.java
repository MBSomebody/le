package leteecode.algo;

import java.util.*;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add("()");
            return res;
        }

        gen(res, "", n, 0, 0);
        return res;
    }

    private void gen(List<String> res, String tmp, int n, int lc, int rc) {
        if (tmp.length() == 2 * n) {
            if (isValid(tmp)) {
                res.add(tmp);
            }
            return;
        }
        if (lc < n) {
            gen(res, tmp + "(", n, lc + 1, rc
            );
        }
        if (rc < n) {
            String tmp2 = tmp + ")";
            gen(res, tmp2, n, lc, rc + 1);
        }


    }

    private boolean isValid(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
