package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/description/
 */
public class WorldBreak {

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> dict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        //String s = "leetcode";
        //List<String> dict = Arrays.asList("leet", "code");

        System.out.println(new WorldBreak().wordBreak(s, dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        if (wordDict.isEmpty()) {
            return false;
        }

        HashSet<String> dict = new HashSet<>();
        for (String is:wordDict) {
            dict.add(is);
        }

        // return findBreak(s, 0, s.length()-1, dict, new HashMap<>());
        return findBreak3(s, dict);
    }

    private boolean findBreak(String s, int idx, HashSet<String> dict, HashMap<String, Boolean> result) {

        if (idx>s.length()) {
            return false;
        }

        if ( result.get(s.substring(idx, s.length()))!=null) {
            return true;
        }

        for (int i = idx; i < s.length(); i++) {
            String sb = s.substring(idx, i+1);
            if (dict.contains(sb)) {
                result.put(s.substring(idx, i+1), true);
                if (i+1<s.length()) {
                    if (findBreak(s, i + 1, dict, result)) {
                        return true;
                    }
                }
                else {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean findBreak(String s, int start, int end, HashSet<String> dict, HashMap<String, Boolean> result) {
        String precheck = s.substring(start,end+1);
        if (result.get(precheck)!=null) {
            return true;
        }

        for (int i = end; start<=i; i--) {
            String sub = s.substring(start,i+1);
            if (dict.contains(sub)) {

                if (i+1<s.length()) {
                    if (findBreak(s, i+1, end, dict, result)) {
                        result.put(precheck, true);
                        return true;
                    }
                }
                else {
                    result.put(precheck, true);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findBreak3(String s, Set<String> dict) {
        if(s==null || s.length()==0)
            return true;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++)
        {
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++)
            {
                if(res[j] && dict.contains(str.toString()))
                {
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
}
