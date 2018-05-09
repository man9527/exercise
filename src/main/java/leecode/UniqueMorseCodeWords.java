package leecode;

import java.util.HashSet;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] s = {"gin", "zen", "gig", "msg"};
        System.out.println(new UniqueMorseCodeWords().uniqueMorseRepresentations(s));
    }

    public int uniqueMorseRepresentations(String[] words) {

        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < words[i].length(); j++) {
                int idx = words[i].charAt(j)-'a';
                sb.append(morseCode[idx]);
            }

            result.add(sb.toString());
        }

        
        return result.size();

    }
}
