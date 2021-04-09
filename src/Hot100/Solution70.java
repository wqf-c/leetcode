package Hot100;

/**
 * @author wqf
 * @date 2021/3/24 22:41
 * @Email:284660487@qq.com
 */
public class Solution70 {

    public int climbStairs(int n) {
        //...可以不用数组
        if(n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

}
