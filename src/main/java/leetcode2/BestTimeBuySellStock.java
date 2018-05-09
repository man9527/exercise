package leetcode2;

public class BestTimeBuySellStock {

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new BestTimeBuySellStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]-prices[i]>profit) {
                    profit=prices[j]-prices[i];
                }
            }
        }

        return profit;

    }
}
