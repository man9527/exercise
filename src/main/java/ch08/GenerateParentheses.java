package ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        return generateParenthesisInternal(n);
    }

    public List<String> generateParenthesisInternal(int n) {

        if (n==0) {
            return Arrays.asList("");
        }

        List<String> subResult = generateParenthesisInternal(n-1);

        HashSet<String> dedup = new HashSet<>();

        for(String s:subResult) {
            dedup.add("()"+s);
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(s.charAt(j));
                }
                sb.append("()");
                sb.append(s.substring(i));
                dedup.add(sb.toString());
            }
        }

        return new ArrayList<>(dedup);
    }


}
