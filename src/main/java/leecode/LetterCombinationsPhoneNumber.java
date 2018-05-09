package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsPhoneNumber().letterCombinations("234"));
    }
    public List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return lc(map, digits);

    }

    private List<String> lc(Map<Character, String> map, String digits) {
        if (digits.length()==0) {
            return Collections.emptyList();
        }
        if (digits.length()==1) {
            String s = map.get(digits.charAt(0));
            List<String> result = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                result.add(""+s.charAt(i));
            }
            return result;
        }

        List<String> substring = lc(map, digits.substring(1));
        String s = map.get(digits.charAt(0));

        List<String> finalResult = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for(String sub:substring) {
                finalResult.add(s.charAt(i)+sub);
            }
        }

        return finalResult;
    }
}
