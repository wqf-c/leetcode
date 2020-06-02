package solution46to90;

/**
 * Author: wqf
 * Date: 2020/2/28
 * Time: 1:24
 */
public class Solution48 {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for(int i = 0; i < n / 2; ++i){
      for(int j = i; j < n - i - 1; ++j){
        int  temp = matrix[i][j];
        matrix[i][j]=matrix[n-j-1][i];
        matrix[n-j-1][i]=matrix[n-1-i][n-j-1];
        matrix[n-1-i][n-j-1]=matrix[j][n-1-i];
        matrix[j][n-1-i]=temp;
      }
    }
  }
}
