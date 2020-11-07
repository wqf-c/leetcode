package DP;

/**
 * @author wqf
 * @date 2020/11/1 11:31
 * @Email:284660487@qq.com
 */
public class offer14_1 {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j < i; ++j){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
