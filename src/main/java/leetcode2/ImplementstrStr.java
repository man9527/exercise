package leetcode2;

public class ImplementstrStr {

    public static void main(String[] args) {
       
        System.out.println(new ImplementstrStr().strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {

        if (haystack.equals(needle)) {
            return 0;
        }

        if (needle.length()>haystack.length()) {
            return -1;
        }

        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        int index = -1;

        for (int i = 0; i < haystack.length(); i++) {

            if (i + needle.length()>haystack.length()) {
                return -1;
            }
            boolean allmatch = true;

            for (int j = 0, k=i; j < needle.length() && k<haystack.length(); j++,k++) {
                if (haystackArr[k]!=needleArr[j]) {
                    allmatch = false;
                    break;
                }
            }

            if (allmatch) {
                return i;
            }
        }

        return index;
    }

}
