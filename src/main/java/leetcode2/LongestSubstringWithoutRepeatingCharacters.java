package leetcode2;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    int max = 0;

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ll = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ll.lengthOfLongestSubstring("tmmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {
        // lengthOfLongestSubstringRec(s).length();
        return lengthOfLongestSubstring2(s);
    }

    public String lengthOfLongestSubstringRec(String s) {
        if (s.length()==1) {
            max = Math.max(max, 1);
            return s;
        }

        String subs = lengthOfLongestSubstringRec(s.substring(1, s.length()));
        char c = s.charAt(0);
        int dup = -1;
        for (int i = 0; i < subs.length(); i++) {
            if (c==subs.charAt(i)) {
                dup = i;
                break;
            }
        }

        if (dup==-1) {
            String r = c + subs;
            max = Math.max(max, r.length());
            return r;
        } else {
            String r = c + subs.substring(0, dup);
            max = Math.max(max, r.length());
            return r;
        }

    }

    public int lengthOfLongestSubstring2(String s) {

        HashMap<Character, Integer> set = new HashMap<>();

        int max = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            if ( set.containsKey(s.charAt(i)) ) {
                max = Math.max(max, i-begin);
                int idx = set.get(s.charAt(i));

                int oldbegin = begin;

                begin = idx+1;
                for (int j = oldbegin; j < begin; j++) {
                    set.remove(s.charAt(j));
                }

            } else {
                max = Math.max(max, i-begin+1);
            }
            set.put(s.charAt(i), i);
        }

        return max;

    }
}
