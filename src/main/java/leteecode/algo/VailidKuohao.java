package leteecode.algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class VailidKuohao {

    public boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        int n = 1;
        stack.push(s.charAt(0));
        while (n < s.length()) {
            char c = s.charAt(n);
            if (stack.empty() || stack.peek() != mp.get(c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
            n++;
        }
        return stack.empty()  ;

    }

    public static void main(String[] args) {
        System.out.println(new VailidKuohao().isValid("(){[]"));
    }
}
