package leetcode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "cod");

        System.out.println(new WordBreak().wordBreak(s, dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        if (wordDict.isEmpty()) {
            return false;
        }
        HashSet<String> dict = new HashSet<>();

        for(String ss:wordDict) {
            dict.add(ss);
        }

        boolean[] res = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            StringBuffer sb = new StringBuffer(s.substring(0, i+1));

            for (int j = 0; j <= i; j++) {
                if ( (j==0 || res[j-1]) && wordDict.contains(sb.toString())) {
                    res[i] = true;
                    break;
                } else {
                    sb.deleteCharAt(0);
                }
            }
        }

        return res[s.length()-1];
    }
}
