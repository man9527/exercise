package ch08;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange {

    public static void main(String[] args) {
        int [] coins = {2};
        System.out.println(new CoinChange().coinChange(coins, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int[] tables = new int[amount+1];
        for (int i = 0; i < tables.length; i++) {
            tables[i]=Integer.MIN_VALUE;
        }
        return coinChangInternal(coins, tables, amount);
    }

    public int coinChangInternal(int[] coins, int[] tables, int amount) {

        if (amount==0) {
            return 0;
        }

        if (tables[amount]>Integer.MIN_VALUE) {
            return tables[amount];
        }

        for (int i = 1; i < tables.length; i++) {
            ArrayList<Integer> nums = new ArrayList<>();
            for (int j = 0; j < coins.length; j++) {
                if (i>=coins[j]) {
                    int num = coinChangInternal(coins, tables, i-coins[j]);
                    if (num>-1) {
                        nums.add(num+1);
                    }
                }
            }

            if (nums.size()>0) {
                int ans = Integer.MAX_VALUE;
                for (Integer integer : nums) {
                    ans = Math.min(ans, integer);
                }
                tables[i]=ans;
            } else {
                tables[i]=-1;
            }

        }

        return tables[amount];

    }


}
