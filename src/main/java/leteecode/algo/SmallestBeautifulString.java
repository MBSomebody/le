package leteecode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestBeautifulString {

    public String smallestBeautifulString(String s, int k) {

        if (s.isEmpty() || k <= 0) {
            return "";
        }
        List<Character> cs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            cs.add((char) ('a' + i));
        }

        System.out.println(Arrays.deepToString(cs.toArray()));
        return rec(s, cs);

    }

    private String rec(String s, List<Character> cs) {
        if (s.isEmpty()) {
            return "";
        }
        int l = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i = l - 1; i >= 0; i--) {
            if (s.charAt(i) == cs.get(cs.size() - 1)) {
                continue;
            } else {
                int idx = cs.indexOf(sb.charAt(i));
                for (int h = idx + 1; h < cs.size(); h++) {
                    sb.setCharAt(i, cs.get(h));
                    if (check(sb.toString(), i)) {
                        for (int j = i + 1; j < l; j++) {
                            for (int k = 0; k < cs.size(); k++) {
                                char o = sb.charAt(j);
                                sb.setCharAt(j, cs.get(k));
                                if (check(sb.toString(), j)) {
                                    break;
                                } else {
                                    sb.setCharAt(j, o);
                                }
                            }
                        }
                        return sb.toString();
                    }
                }
            }
        }


        return "";
    }


    private boolean check(String s, int idx) {

        int l = s.length();
        boolean res = true;
        if (idx + 1 < l) {
            res = res && !(s.charAt(idx) == s.charAt(idx + 1));
        }

        if (idx - 1 >= 0) {
            res = res && !(s.charAt(idx) == s.charAt(idx - 1));
        }

        if (idx - 2 >= 0) {
            res = res && !(s.charAt(idx) == s.charAt(idx - 2));
        }

        if (idx + 2 < l) {
            res = res && !(s.charAt(idx) == s.charAt(idx + 2));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestBeautifulString().smallestBeautifulString("ced", 6));
    }
}
