package leetcode4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class AmbiguousCoordinates {

    public static void main(String[] args) {
        out.println( new AmbiguousCoordinates().ambiguousCoordinates("(123)"));
    }

    public List<String> ambiguousCoordinates(String S) {

        if (S==null || S.length()<=2) {
            return Collections.emptyList();
        }
        return ambiguousCoordinatesRec(S.substring(1, S.length()-1));
    }

    public List<String> ambiguousCoordinatesRec(String S) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= S.length()-1; i++) {

            String s1 = S.substring(0, i);
            String s2 = S.substring(i, S.length());

            result.addAll(deal(s1, s2));
        }
        
        
        return result;
    }

    private List<String> deal(String s1, String s2) {

        List<String> l1 = addDot(s1);
        List<String> l2 = addDot(s2);
        List<String> result = new ArrayList<>();
        for(String l1s:l1) {
            for(String l2s:l2) {
                result.add("("+l1s+", " + l2s + ")");
            }
        }

        return result;
    }

    private List<String> addDot (String s) {
        List<String> result = new ArrayList<>();

        if (isvalid(s)) {
            result.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.insert(i, '.');
            String ss = sb.toString();

            if (isvalid(ss))
                result.add(ss);
        }

        return result;
    }

    private boolean isvalid(String s) {

        if (s.startsWith("00")) {
            return false;
        }

        if (s.indexOf(".") < 0 && s.length()>1 && s.startsWith("0")) {
            return false;
        }

        if (s.indexOf(".") > 1 && s.startsWith("0")) {
            return false;
        }

        if (s.indexOf(".") >= 0 && s.endsWith("0")) {
            return false;
        }

        return true;
    }

}
