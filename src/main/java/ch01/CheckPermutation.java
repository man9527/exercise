package ch01;

import java.util.Arrays;

public class CheckPermutation {

    public boolean CheckPermutation(String str1, String str2) {

        if (str1.length()!=str2.length()) {
            return false;
        }

        char[] a = new char[str1.length()];

        for (int i=0; i<str1.length(); i++) {
            a[i]=str1.charAt(i);
        }

        Arrays.sort(a);

        char[] b = new char[str1.length()];

        for (int i=0; i<str2.length(); i++) {
            b[i]=str2.charAt(i);
        }

        Arrays.sort(b);

        for (int i=0; i<a.length; i++) {
            if (a[i]!=b[i]) {
                return false;
            }
        }

        return true;

    }
    public static void main(String[] args) {
        CheckPermutation cp = new CheckPermutation();

        System.out.println(cp.CheckPermutation("abcde", "dbcae"));
        System.out.println(cp.CheckPermutation("abcde", "dbbae"));

    }

}
