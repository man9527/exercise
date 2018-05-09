package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        List<String> r = new LetterCombinations().letterCombinations("23");
        System.out.println(r);
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

    private List<String> lc(HashMap<Character, String> map, String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length()==1) {
            String keyString = map.get(digits.charAt(0));

            for (int i = 0; i < keyString.length(); i++) {
                result.add(String.valueOf(keyString.charAt(i)));
            }

            return result;
        }

        List<String> subResult = lc(map, digits.substring(1));

        String keyString = map.get(digits.charAt(0));

        for (int i = 0; i < keyString.length(); i++) {
            for(String sub:subResult) {
                result.add(String.valueOf(keyString.charAt(i)) + sub);
            }
        }

        return result;

    }


}
