package hackrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/electronics-shop/problem
 *
 * Best solution:
 * https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Implementation/Electronics%20Shop/Solution.java
 */
public class ElectronicsShop {


    static int getMoneySpent(int[] keyboards, int[] drives, int s){
        // Complete this function
        boolean[] kt = new boolean[1000000];
        boolean[] dt = new boolean[1000000];

        int minK = Integer.MAX_VALUE;
        for (int i = 0; i < keyboards.length; i++) {
            kt[keyboards[i]]=true;
            if (keyboards[i]<minK) {
                minK=keyboards[i];
            }
        }

        int minD = Integer.MAX_VALUE;
        for (int i = 0; i < drives.length; i++) {
            dt[drives[i]]=true;
            if (drives[i]<minD) {
                minD = drives[i];
            }
        }

        if (minK+minD>s) {
            return -1;
        }

//        if (minK+minD==s) {
//            return minD+minK;
//        }
        
        int result = 0;
        for (int i = kt.length-1; i >=0; i--) {
            if (kt[i]) {
                for (int j = dt.length-1; j >=0 ; j--) {
                    if (dt[j] && (i+j>result) && (i+j)<=s) {
                        result=i+j;
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
    
}
