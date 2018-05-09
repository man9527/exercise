package leetcode5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GoatLatin {

    public static void main(String[] args) {
        System.out.println(new GoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public String toGoatLatin(String S) {

        HashSet<Character> vowl = new HashSet<>();
        vowl.add('a');
        vowl.add('e');
        vowl.add('i');
        vowl.add('o');
        vowl.add('u');
        vowl.add('A');
        vowl.add('E');
        vowl.add('I');
        vowl.add('O');
        vowl.add('U');

        String[] sub = S.split(" ");
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < sub.length; i++) {
            String ss = sub[i];
            if (ss.trim().isEmpty()) {
                continue;
            }

            if (vowl.contains(ss.charAt(0))) {
                ss = ss + "ma";
                for (int j = 0; j < i+1; j++) {
                    ss += "a";
                }
                result.add(ss);
            } else {
                String newS = cuthead(ss);
                newS+="ma";
                for (int j = 0; j < i+1; j++) {
                    newS += "a";
                }
                result.add(newS);
            }
        }

        return String.join(" ", result);
    }

    private String cuthead(String ss) {
        StringBuilder sb = new StringBuilder(ss);
        sb.append(ss.charAt(0));
        sb.deleteCharAt(0);
        return sb.toString();
    }

}
