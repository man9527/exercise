package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("100"));
    }

    public int numDecodings(String s) {
         List<LinkedList<Integer>> rr = numDecodingsrec(s);

         return rr.size();

    }

    public List<LinkedList<Integer>> numDecodingsrec(String s) {

        int currentChar = s.charAt(0)-'1'+1;

        if (! (currentChar > 0 && currentChar<27)) {
            return Collections.emptyList();
        }

        if (s.length()==1) {
            if (currentChar>0 && currentChar<27) {
                List<Integer> a = Arrays.asList(currentChar);
                return Arrays.asList(new LinkedList(a));
            } else {
                return Collections.emptyList();
            }
        }


        List<LinkedList<Integer>> subresult = numDecodingsrec(s.substring(1));

        List<LinkedList<Integer>> result = new LinkedList<>();

        if (subresult.isEmpty()) {
            List<Integer> a = Arrays.asList(currentChar);
            return Arrays.asList(new LinkedList(a));
        } else {
            for (LinkedList<Integer> ll : subresult) {
                LinkedList<Integer> newll = new LinkedList<>(ll);
                newll.addFirst(currentChar);
                result.add(newll);
            }

            for (LinkedList<Integer> ll : subresult) {
                int first = ll.get(0);

                if (currentChar * 10 + first <= 26) {
                    LinkedList<Integer> newll = new LinkedList<>(ll);
                    newll.set(0, currentChar * 10 + first);
                    result.add(newll);
                }
            }
        }

        return result;
    }
}
