package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/7
 * Time: 2:06
 */
public class Solution62 {

  //回溯超时
//  int num = 0;
//  int m = 0;
//  int n = 0;
//  public int uniquePaths(int m, int n) {
//    boolean[][] wayFlag = new boolean[m][n];
//    wayFlag[0][0] = true;
//    this.m = m;
//    this.n = n;
//    findWay(wayFlag, 0, 0);
//    return num;
//  }
//
//  public void findWay(boolean[][] wayFlag, int positionM, int positionN){
//    if(positionM == (m - 1) && positionN == (n - 1)){
//      num++;
//      return;
//    }
//
//    if(positionM + 1 < m ){
//      wayFlag[positionM + 1][positionN] = true;
//      findWay(wayFlag, positionM + 1, positionN);
//      wayFlag[positionM + 1][positionN] = false;
//    }
//
//    if(positionN + 1 < n ){
//      wayFlag[positionM][positionN + 1] = true;
//      findWay(wayFlag, positionM, positionN + 1);
//      wayFlag[positionM][positionN + 1] = false;
//    }
//  }
  //动态规划
  public int uniquePaths(int m, int n) {
    int ways[][] = new int[m][n];
    for(int i = 0; i < m; ++i){
      ways[i][0] = 1;
    }
    for(int i = 0; i < n; ++i){
      ways[0][i] = 1;
    }
    for(int i = 1; i < m; ++i){
      for(int j = 1; j < n; ++j){
        ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
      }
    }
    return ways[m - 1][n - 1];
  }
}
