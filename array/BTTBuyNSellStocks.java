package array;
public class BTTBuyNSellStocks {
    public static void main(String[] args) {
        int arr[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(arr));
    }
    /*  min is minimum in array, profit depends on min.so we can have normal min condition there
     *  max depends on profit -> if current profit> profit -> only then we change max
     *  we count profit only when manidx>minidx
     * 
     *  Best Time to Buy and Sell Stock: https://leetcode.com/problems/best-time-to-buy-
and-sell-stock/ 
    */


    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0, minidx = -1, maxidx = -1;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minidx = i;
            }
            int cp = prices[i] - min;
            if (cp > profit && i > minidx) {
                max = prices[i];
                maxidx = i;
            }
            
            if (maxidx > minidx) {
                profit = max - min;
            }
        }
        if (maxidx == -1) {
            return 0;
        }
        return profit;
    }
}
