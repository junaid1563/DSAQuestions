public class BTTBuyNSellStocks {
    public static void main(String[] args) {
        int arr[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(arr));
    }

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
