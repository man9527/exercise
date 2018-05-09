package leetcode2;

public class StringCompression {

    public static void main(String[] args) {
        char[] c = {'a','b','c','d','d','d','d','d','d','d','d','d','d','d','d','d','d','d'};
        int r = new StringCompression().compress2( c );

        System.out.println(r);
    }

    public int compress(char[] chars) {

        if (chars==null && chars.length==0) {
            return 0;
        }

        int currentCount = 1;
        char currentChar = chars[0];
        int resultIndex = -1;

        for (int i = 1; i < chars.length; i++) {

            if (currentChar==chars[i]) {
                currentCount++;
            } else {

                if (currentCount>1) {
                    resultIndex++;
                    chars[resultIndex]=currentChar;
                    char[] countStr = Integer.toString(currentCount).toCharArray();

                    for (int j = 0; j < countStr.length; j++) {
                        resultIndex++;
                        chars[resultIndex]=countStr[j];
                    }
                } else {
                    resultIndex++;
                }

                currentCount=1;
                currentChar = chars[i];
            }
        }

        if (currentCount>1) {
            resultIndex++;
            chars[resultIndex]=currentChar;
            char[] countStr = Integer.toString(currentCount).toCharArray();

            for (int j = 0; j < countStr.length; j++) {
                resultIndex++;
                chars[resultIndex]=countStr[j];
            }
        } else {
            resultIndex++;
        }

        return resultIndex+1;
    }

    public int compress2(char[] chars) {
        int idx = 0;	// index of result
        Character prev = null;
        for (int i = 0; i < chars.length; i++) {
            // different char, set char head at idx
            if (prev == null || chars[i] != prev) {
                prev = chars[i];
                chars[idx++] = chars[i];
                // same char
            } else {
                int count = 2;	// count is 2 when found
                // count toward
                while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                    i++;
                    count++;
                }
                // write count num after char head
                String cnt = String.valueOf(count);
                for (char c: cnt.toCharArray())
                    chars[idx++] = c;
            }
        }
        return idx;
    }
}
