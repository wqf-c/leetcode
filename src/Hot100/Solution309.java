package Hot100;

/**
 * @author wqf
 * @date 2021/4/20 22:14
 * @Email:284660487@qq.com
 */
public class Solution309 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        //dp[i][0] 不持股且当天没卖出
        //dp[i][1] 持股
        //dp[i][2] 不持股且当天卖出

        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;

        for(int i = 1; i < prices.length; ++i){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

}
