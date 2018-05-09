package hackrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/drawing-book/problem
 */
public class DrawingBook {

    static int solve(int n, int p){
        if (p==1 || p==n) {
            return 0;
        }
        // Complete this function
        int total = n/2;
        int c = p/2;

        if (c>total/2) {
            return total-c;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }

}
