package leecode;

public class ReverseString {
    public String reverseString(String s) {

        char[] sc = s.toCharArray();

        int i=0;
        int j=sc.length-1;

        while(i<j) {
            char t = sc[i];
            sc[i]=sc[j];
            sc[j]=t;

            i++;
            j--;

        }

        return new String(sc);
    }
}
