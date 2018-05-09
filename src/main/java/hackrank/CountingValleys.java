package hackrank;

import java.util.Scanner;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        // Complete this function
        int height = 0;
        boolean valley_start = false;
        int valley_count=0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='U') {
                if (height<0 && valley_start) {
                    valley_count++;
                    valley_start=false;
                }
                height++;
            } else if (s.charAt(i)=='D') {
                if (height==0) {
                    valley_start=true;
                }
                height--;
            }


        }

        return valley_count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}
