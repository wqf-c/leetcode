package DP;

/**
 * @author wqf
 * @date 2020/11/2 15:30
 * @Email:284660487@qq.com
 */
public class Solution1314 {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int height = mat.length;
        int width = mat[0].length;
        int[][] newMat = new int[height + 2 * K][width + 2 * K];
        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                newMat[i + K][j + K] = mat[i][j];
            }
        }
        int[][] rst = new int[height][width];
        for(int i = 0; i <= 2 * K; ++i){
            for(int j = 0; j <= 2 * K; ++j){
                rst[0][0] += newMat[i][j];
            }
        }
        for(int i = 1; i < height; ++i){
            rst[i][0] = rst[i - 1][0];
            for(int j = K; j <= 2 * K; ++j){
                rst[i][0] += newMat[i + 2 * K][j];
                rst[i][0] -= newMat[i - 1][j];
            }
        }
        for(int i = 0; i < height; ++i){
            for(int j = 1; j < width; ++j){
                rst[i][j] = rst[i][j - 1];
                for(int k = 0; k <= 2 * K; ++k){
                    rst[i][j] += newMat[i + k][j + 2 * K];
                    rst[i][j] -= newMat[i + k][j - 1];
                }
            }
        }
        return rst;
    }

    //前缀和
    public int[][] matrixBlockSum_1(int[][] mat, int K){
        int height = mat.length;
        int width = mat[0].length;
        int[][] dp = new int[height][width];
        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                int num1 = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                int num2 = i - 1 >= 0 ? dp[i - 1][j] : 0;
                int num3 = j - 1 >= 0 ? dp[i][j - 1] : 0;
                dp[i][j] = mat[i][j] + num2 + num3 - num1;
            }
        }
        int[][] res = new int[height][width];
        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                int num1 = j - K - 1 >= 0 && i - K - 1 >= 0 ? dp[i - K - 1][j - K - 1] : 0;
                int num2 = 0;
                int num3 = 0;
                int x0 = Math.max(0, j - K - 1);
                int y0 = Math.max(0, i - K - 1);
                int x1 = Math.min(j + K, width - 1);
                int y1 = Math.min(i + K, height - 1);
                if(i - K - 1 < 0) num2 = 0;
                else num2 = dp[y0][x1];
                if(j - K - 1 < 0) num3 = 0;
                else num3 = dp[y1][x0];
                res[i][j] = dp[y1][x1]  + num1 - num2 - num3;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Solution1314 solution1314 = new Solution1314();
        solution1314.matrixBlockSum_1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
    }
}
