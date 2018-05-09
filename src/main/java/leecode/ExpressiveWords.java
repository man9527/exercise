package leecode;

import java.util.HashSet;

public class ExpressiveWords {

    public static void main(String[] args) {

        String s =  "heeellooo";
        String[] words = {"hello", "hi", "helo"};

//        String s =  "vvvppppeeezzzzztttttkkkkkkugggggbbffffffywwwwwwbbbccccddddddkkkkksssppppddpzzzzzhhhhbbbbbmmmy";
//        String[] words = {"vvpeezzttkkugbbfywwbcdkkspdpzzhhbmmy"};

//        String s =  "aaaa";
//        String[] words = {"aaaaa"};

//        String s =  "abcd";
//        String[] words = {"abc", "hi", "helo"};


        System.out.println(new ExpressiveWords().expressiveWords(s, words));
    }

    public int expressiveWords(String S, String[] words) {

        int result = 0;

        for(String stoc:words) {
            if (isGood(S, stoc)) {
                result++;
            }
        }

        return result;
    }

    private boolean isGood(String s, String stoc) {

        int i=0, j=0;

        while(i<s.length() && j<stoc.length()) {
            if (s.charAt(i)!=stoc.charAt(j)) {
                return false;
            }

            int currentChar = s.charAt(i);
            int moveCount = 0;

            while (i<s.length() && s.charAt(i)==currentChar) {
                moveCount++;
                i++;
            }

            int currentChar2 = stoc.charAt(j);
            int moveCount2 = 0;

            while (j<stoc.length() && stoc.charAt(j)==currentChar2) {
                moveCount2++;
                j++;
            }

            if (moveCount2>moveCount) {
                return false;
            }

            if (moveCount<3 && moveCount!=moveCount2) {
                return false;
            }
        }

        if (i==s.length() && j==stoc.length())
        return true;
        else
            return false;

    }


}
