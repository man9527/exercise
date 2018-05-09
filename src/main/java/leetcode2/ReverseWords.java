package leetcode2;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("   a   b "));
    }

    public String reverseWords(String s) {

        s = " " + s;
        StringBuilder sb = new StringBuilder();

        int lastPos = s.length();
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i)==' ') {
                String sub = s.substring(i+1, lastPos).trim();
                if (sub.length()>0) {
                    if (sb.length() != 0) {
                        sb.append(" ");
                    }
                    sb.append(sub);
                }
                lastPos=i;
            }
        }

        return sb.toString().trim();
    }
    
}
