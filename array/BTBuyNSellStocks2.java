package array;

public class BTBuyNSellStocks2 {
    public static void main(String[] args) {
        int[] arr = { 6, 1, 3, 2, 4, 7 };
        System.out.println(maxProfit(arr));
    }

    /**
     * 
     * @param prices
     * @return
     *         Approach
     *         In this we keep track of last Profit as well
     *         if current profit goes smaller than last profit then we sell stock
     *         and reset lastProfit=0, min =prices[i] and also add lastProfit in
     *         total profit
     * 
     *         Now at the end if lastProfit!=0, then it means we still have some
     *         profit that is still need to be added in total profit. So after loop
     *         we check if lastProfit!=0, then we add it to total profit
     * 
     *         https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     */

    public static int maxProfit(int[] prices) {
        int profit = 0, lastProfit = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int cp = prices[i] - min;
            if (cp < lastProfit) {
                profit += lastProfit;
                lastProfit = 0;
                min = prices[i];
            } else {
                if (cp > 0) {
                    lastProfit = cp;

                }
            }
        }
        if (lastProfit != 0) {
            profit += lastProfit;
        }
        return profit;
    }
}