package hackrank;

import java.util.Scanner;
import java.util.TreeSet;

public class BirthdayCandle {


    static int birthdayCakeCandles(int n, int[] ar) {

        int max=0;
        int maxCount=0;

        for(int i=0; i<ar.length; i++) {
            if (ar[i]>max) {
                max = ar[i];
                maxCount=1;
            } else if (ar[i]==max){
                maxCount++;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
