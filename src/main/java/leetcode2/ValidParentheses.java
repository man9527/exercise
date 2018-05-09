package leetcode2;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("]"));
    }

    public boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                st.push(map.get(s.charAt(i)));
            } else {
                if (st.empty() || st.pop()!=s.charAt(i)) {
                    return false;
                }
            }
        }

        return st.empty();
        
    }
}
