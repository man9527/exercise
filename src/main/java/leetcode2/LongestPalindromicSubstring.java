package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {

        if (s.length()<2) {
            return s;
        }

        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==null) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(s.charAt(i),l);
            } else {
                map.get(s.charAt(i)).add(i);
            }
        }

        String currentAnswer = s.substring(0,1);

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))!=null) {
                List<Integer> l = map.get(s.charAt(i));
                for(int j=l.size()-1; 0<=j; j--) {
                    int ii = l.get(j);
                    if (ii+1>=i) {
                        String curr = s.substring(i, ii + 1);
                        if (isGood(curr)) {
                            if (currentAnswer == null || curr.length() > currentAnswer.length()) {
                                currentAnswer = curr;
                            }
                            break;
                        }
                    }
                }
            }
        }

        return currentAnswer;
    }

    private boolean isGood(String substring) {
        int i=0;
        int j=substring.length()-1;
        while (i<j) {
            if (substring.charAt(i)!=substring.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

}
