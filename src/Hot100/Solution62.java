package Hot100;

/**
 * @author wqf
 * @date 2021/3/23 22:28
 * @Email:284660487@qq.com
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; ++i){
            dp[0][i] = 1;
        }
        for(int j = 0; j < m; ++j){
            dp[j][0] = 1;
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
