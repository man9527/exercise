package leetcode2;

import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqueCharacterString {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterString().firstUniqChar("cc"));
    }

    public int firstUniqChar(String s) {

        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> dup = new HashSet<>();

        int currentUniqueIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set1.contains(c)) {
                dup.add(c);
            } else {
                set1.add(c);
            }

            if (currentUniqueIndex<s.length() && dup.contains(s.charAt(currentUniqueIndex))) {
                while(currentUniqueIndex<s.length() && dup.contains(s.charAt(currentUniqueIndex)) ) currentUniqueIndex++;
            }
        }

        if (currentUniqueIndex>=s.length())
        return -1;
        else
            return currentUniqueIndex;


    }

}
