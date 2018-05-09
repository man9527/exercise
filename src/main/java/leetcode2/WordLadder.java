package leetcode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordLadder {

    public static void main(String[] args) {
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
//        System.out.println(new WordLadder().ladderLength("hit", "cog", wordList) + 1);

        List<String> wordList = Arrays.asList("hot", "dog");
        System.out.println(new WordLadder().ladderLength("hot", "dog", wordList));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        HashSet<String> beginWith = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        beginWith.add(beginWord);
        int count = 1;

        while(!beginWith.isEmpty()) {

            HashSet<String> newSet = new HashSet<>();

            for (String begin : beginWith) {
                char[] chars = begin.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (chars[i]!=j) {
                            char temp = chars[i];
                            chars[i] = j;
                            String newString = new String(chars);

                            if (newString.equals(endWord)) {
                                return count+1;
                            }

                            if (!visited.contains(newString) && dict.contains(newString)) {
                                visited.add(newString);
                                newSet.add(newString);
                            }
                            chars[i]=temp;
                        }
                    }
                }
            }

            beginWith = newSet;
            count++;
        }

        return 0;
    }

}
