package solution46to90;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/3/4
 * Time: 0:31
 */
public class Solution54 {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if(matrix == null || matrix.length == 0) return list;
    int width = matrix[0].length - 1;
    int height = matrix.length - 1;
    int n = 0;
    while (true){
      if(list.size() == (width + 1) * (height + 1)) break;
      if(n == height - n){
        for(int i = n; i <= width - n; ++i){
          list.add(matrix[n][i]);
        }
        break;
      }
      if(n == width - n){
        for(int i = n; i <= height - n; ++i){
          list.add(matrix[i][n]);
        }
        break;
      }
      for(int i = n; i < width - n; ++i){
        list.add(matrix[n][i]);
      }
      for(int i = n; i < height - n; ++i){
        list.add(matrix[i][width - n]);
      }
      for(int i = width - n; i > n; i--){
        list.add(matrix[height - n][i]);
      }
      for(int i = height - n; i > n; i--){
        list.add(matrix[i][n]);
      }
      n++;
    }
    return list;
  }
}
