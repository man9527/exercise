package ch01;

/**
 * https://leetcode.com/problems/string-compression/description/
 */
public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a','a','a','a','a','a','a','a','a','a'};
        new StringCompression().compress(chars);
        System.out.println(chars);
    }

    public int compress(char[] chars) {

        if (chars.length<=1) {
            return chars.length;
        }

        int currentCount=1;
        char current = chars[0];
        int currentIndex=0;
        for (int i = 1; i < chars.length; i++) {
            if (current==chars[i]) {
                currentCount++;
            } else {
                if (currentCount==1) {
                    chars[currentIndex]=current;
                    currentIndex++;
                } else {
                    chars[currentIndex]=current;
                    currentIndex++;

                    String r = Integer.toString(currentCount);
                    for (int j = 0; j < r.length(); j++) {
                        chars[currentIndex]=r.charAt(j);
                        currentIndex++;
                    }
                }

                current=chars[i];
                currentCount=1;
            }
        }

        if (currentCount==1) {
            chars[currentIndex]=current;
            currentIndex++;
        } else {
            chars[currentIndex]=current;
            currentIndex++;

            String r = Integer.toString(currentCount);
            for (int j = 0; j < r.length(); j++) {
                chars[currentIndex]=r.charAt(j);
                currentIndex++;
            }

        }

        return currentIndex;
    }


}
