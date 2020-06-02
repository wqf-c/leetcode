package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/16
 * Time: 0:43
 */
public class Solution74 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int w = matrix.length;
    if(w == 0) return false;
    int h = matrix[0].length;
    int left = 0;
    int right = w * h - 1;
    while (left <= right){
      int mid = (left + right) / 2;
      int midVal = matrix[mid / h][mid % h];
      if(midVal == target) return true;
      else if(midVal < target) left = midVal + 1;
      else right = midVal - 1;
    }
    return false;
  }
}
