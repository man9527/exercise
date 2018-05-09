package hackrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        // Complete this function
        int[] c = new int[100];

        int total = 0;
        for (int i = 0; i < ar.length; i++) {
            c[ar[i]-1]+=1;
            if (c[ar[i]-1]==2) {
                total+=1;
                c[ar[i]-1]=0;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
    
}
