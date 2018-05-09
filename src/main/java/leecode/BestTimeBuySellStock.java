package leecode;

public class BestTimeBuySellStock {

    
    public int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i+1<prices.length && prices[i]<prices[i+1])
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]-prices[i]>profit) {
                    profit=prices[j]-prices[i];
                }
            }
        }

        return profit;
    }
}
