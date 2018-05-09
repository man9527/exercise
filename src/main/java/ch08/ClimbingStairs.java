package ch08;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }

    public int climbStairs(int n) {

        int[] tables = new int[n];

        for (int i = 0; i < tables.length; i++) {
            tables[i]=0;
        }

        tables[0]=1;
        tables[1]=2;


        for (int i = 2; i < n ; i++) {
            tables[i]=tables[i-1]+tables[i-2];
        }

        return tables[n-1];
    }

}
