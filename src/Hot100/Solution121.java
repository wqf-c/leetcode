package Hot100;

/**
 * @author wqf
 * @date 2021/4/5 10:30
 * @Email:284660487@qq.com
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int leftMin = prices[0];
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] - leftMin > profit){
                profit = prices[i] - leftMin;
            }
            if(prices[i] < leftMin){
                leftMin = prices[i];
            }
        }
        return profit;
    }

}
