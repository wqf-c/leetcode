package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/8
 * Time: 2:37
 */
public class Solution64 {
  //动态规划+贪心
  public int minPathSum(int[][] grid) {
    int w = grid.length;
    int n = grid[0].length;
    int[][] weights = new int[w][n];
    weights[0][0] = grid[0][0];
    for(int i = 1; i < w; ++i){
      weights[i][0] = weights[i - 1][0] + grid[i][0];
    }
    for(int i = 1; i < n; ++i){
      weights[0][i] = weights[0][i - 1] + grid[0][i];
    }
    for(int i = 1; i < w; ++i){
      for(int j = 1; j < n; ++j){
        weights[i][j] = Math.min(weights[i -1][j], weights[i][j - 1]) + grid[i][j];
      }
    }
    return weights[w - 1][n - 1];
  }
}
