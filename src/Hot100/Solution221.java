package Hot100;

/**
 * @author wqf
 * @date 2021/4/13 21:25
 * @Email:284660487@qq.com
 */
public class Solution221 {

    public int maximalSquare(char[][] matrix) {
       // boolean[][][][] dp = new boolean[matrix.length * matrix[0].length][matrix[0].length * matrix[0].length];
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        if(matrix[0][0] == '1'){
            max = 1;
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }
        for(int i = 1; i < matrix.length; ++i){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            int cur = dp[i][0] * dp[i][0];
            if(cur > max) max = cur;
        }
        for(int i = 1; i < matrix[0].length; ++i){
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            int cur = dp[0][i] * dp[0][i];
            if(cur > max) max = cur;
        }
        for(int i = 1;  i < matrix.length; ++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][j] == '1'){
                    if(dp[i - 1][j - 1] != 0 && dp[i - 1][j] != 0 && dp[i][j - 1] != 0){
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                    int cur = dp[i][j] * dp[i][j];
                    if(cur> max) max = cur;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

}
