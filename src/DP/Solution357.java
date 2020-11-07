package DP;

/**
 * @author wqf
 * @date 2020/11/4 23:14
 * @Email:284660487@qq.com
 */
public class Solution357 {

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; ++i){
            dp[i] += dp[i - 1];
            int count = 1;
            for(int j = 1; j < i; ++j){
                count *= (10 - j);
            }
            count *= 9;
            dp[i] += count;
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution357 solution357 = new Solution357();
        System.out.println(solution357.countNumbersWithUniqueDigits(2));
    }
}
