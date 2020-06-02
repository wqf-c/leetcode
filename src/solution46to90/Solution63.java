package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/8
 * Time: 2:26
 */
public class Solution63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int w = obstacleGrid.length;
    int h = obstacleGrid[0].length;
    int[][] steps = new int[w][h];
    int i = 0;
    for(; i < w; ++i){
      if(obstacleGrid[i][0] == 1) break;
      steps[i][0] = 1;
    }
    for(; i < w; ++i) steps[i][0] = 0;
    for(i = 0; i < h; ++i){
      if(obstacleGrid[0][i] == 1) break;
      steps[0][i] = 1;
    }
    for(; i < h; ++i) steps[0][i] = 0;
    for(int j = 1; j < w; ++j){
      for(int k = 1; k < h; ++k){
        if(obstacleGrid[j][k] == 1) steps[j][k] = 0;
        else steps[j][k] = steps[j - 1][k] + steps[j][k - 1];
      }
    }
    return steps[w-1][h-1];
  }
}
