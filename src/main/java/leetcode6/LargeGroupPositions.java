package leetcode6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {

    public static void main(String[] args) {
        System.out.println( new LargeGroupPositions().largeGroupPositions("abccc"));
    }

    public List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> result = new ArrayList<>();
        char currentChar = 0;
        int len = 1;
        int start = -1;

        for (int i = 0; i < S.length(); i++) {
            if (currentChar!=S.charAt(i)) {
                if (len>=3) {
                    result.add(Arrays.asList(start, i-1));
                }
                len=1;
                currentChar = S.charAt(i);
                start = i;
            } else if (i==S.length()-1) {
                if (len>=2) {
                    result.add(Arrays.asList(start, i));
                }
            }
            else {
                len++;
            }
        }

        return result;

    }

}
