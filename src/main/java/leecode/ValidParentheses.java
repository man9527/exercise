package leecode;

import java.util.HashSet;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        HashSet<Character> start = new HashSet<>();
        start.add('('); start.add('['); start.add('{');
        HashSet<Character> end = new HashSet<>();
        end.add(')'); end.add(']'); end.add('}');

        for (int i = 0; i < s.length(); i++) {
            if (start.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (end.contains(s.charAt(i))) {
                if (stack.empty()) return false;
                Character endC = stack.pop();
                if (s.charAt(i)==')'&&endC!='(' || s.charAt(i)==']'&&endC!='[' || s.charAt(i)=='}'&&endC!='{')
                    return false;
            }
        }

        if (stack.empty())
            return true;
        else
            return false;
    }
}
