package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wqf
 * @date 2020/11/5 15:48
 * @Email:284660487@qq.com
 */
public class Solution650 {

    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; ++i){
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1000);
        }
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 1; i <= n; ++i){
            int min = dp[i][0];
            for(int j = 1; j <= i; ++j){
                if(j < i){
                    dp[i][j] = dp[i - j][j] + 1;
                    min = Math.min(dp[i][j], min);
                }else{
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[n][n] - 1;
    }

    public static void main(String[] args){
        Solution650 solution650 = new Solution650();
        System.out.println(solution650.minSteps(3));
    }
}
