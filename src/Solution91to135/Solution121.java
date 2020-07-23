package Solution91to135;

public class Solution121 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] bp = new int[prices.length];
        bp[0] = 0;
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if (bp[i - 1] >= 0) {
                bp[i] = bp[i - 1] + prices[i] - prices[i - 1];
            } else {
                bp[i] = prices[i] - prices[i - 1];
            }
            if (bp[i] > max) max = bp[i];
        }
        return max;
    }
}
