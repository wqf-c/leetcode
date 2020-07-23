package Solution91to135;

public class Solution122 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; ++i){
            int num = prices[i] - prices[i - 1];
            if(num > 0){
                max += num;
            }
        }
        return max;
    }
}
