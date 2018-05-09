package LintCode;

import java.util.HashMap;

public class LongestRepeatingSubsequenceII {

    public static void main(String[] args) {
        System.out.println( new LongestRepeatingSubsequenceII().longestRepeatingSubsequenceII("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaazaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaazaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaazaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 100));
    }

    public int longestRepeatingSubsequenceII(String str, int k) {
        // Write your code here
        HashMap<String, Integer> cache  = new HashMap<>();

        int max = 0;
        for (int i = str.length(); 0<=i; i--) {
            for (int j = 0; j+i < str.length(); j++) {
                String sub = str.substring(j, j+i);
                int count = repeat(str, sub, k , cache);
                if (count>=k) {
                    return sub.length();
                }
            }
        }

        return max;

    }

    private int repeat(String str, String sub, int k, HashMap<String, Integer> cache) {

        if (cache.get(sub)!=null) {
            return cache.get(sub);
        }

        int count = 0;
        for (int i = 0; i + sub.length()-1< str.length() ; ) {
            if (str.indexOf(sub, i)>=0) {
                i= str.indexOf(sub, i)+1;
                count++;
                if (count>=k) {
                    //cache.put(sub, count);
                    break;
                }
            } else {
                break;
            }
        }

        cache.put(sub, count);
        return count;
    }


}
