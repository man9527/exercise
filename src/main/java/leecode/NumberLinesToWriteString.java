package leecode;

public class NumberLinesToWriteString {

    public static void main(String[] args) {
        int[] w = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

        System.out.println(new NumberLinesToWriteString().numberOfLines(w, "abcdefghijklmnopqrstuvwxyz"));
    }

    public int[] numberOfLines(int[] widths, String S) {
        int unitPerline = 100;
        int totalLine = 1;
        int totalw = 0;
        for (int i = 0; i < S.length(); i++) {
            int w = widths[S.charAt(i)-'a'];
            if (totalw+w<=unitPerline) {
                totalw += w;
            } else {
                totalLine+=1;
                totalw = w;
            }
        }



        int[] r = {totalLine, totalw};
        return r;
    }

}
