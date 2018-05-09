package hackrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 */
public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        int[] count = {0,0,0,0,0};

        for (int i = 0; i < ar.length; i++) {
            count[ar[i]-1]=count[ar[i]-1]+1;
        }

        int maxCount = 0;
        int maxIndex = -1;

        for (int i = 0; i < count.length; i++) {
            if (count[i]>maxCount) {
                maxIndex=i;
            }
        }

        return maxIndex+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }

}
