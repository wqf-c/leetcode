package CodeTop;

/**
 * @author wqf
 * @date 2021/5/5 0:01
 * @Email:284660487@qq.com
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int leftMin = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; ++i){
            int cur = prices[i] - leftMin;
            if(cur > max) max = cur;
            if(prices[i] < leftMin) leftMin = prices[i];
        }
        return max;
    }

}
