package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/15
 * Time: 23:40
 */
public class Solution73 {

  public void setZeroes(int[][] matrix) {
    int w = matrix.length;
    int h = matrix[0].length;
    boolean wFlag = false;
    boolean hFlag = false;
    for(int i = 0; i < h; ++i){
      if(matrix[0][i] == 0){
        hFlag = true;
        break;
      }
    }
    for(int i = 0; i < w; ++i){
      if(matrix[i][0] == 0){
        wFlag = true;
        break;
      }
    }
    for(int i = 0; i < w; ++i){
      for(int j = 0; j < h; ++j){
        if(matrix[i][j] == 0){
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for(int i = 0; i < w; ++i) {
      if (matrix[i][0] == 0) {
        if(i == 0){
          continue;
        }
        for (int j = 0; j < h; ++j) {
          matrix[i][j] = 0;
        }
      }
    }
    for(int j = 0; j < h; ++j){
      if(matrix[0][j] == 0){
        if(j == 0){
          continue;
        }
        for(int i = 0; i < w; ++i){
          matrix[i][j] = 0;
        }
      }
    }
    if(hFlag){
      for (int j = 0; j < h; ++j) {
        matrix[0][j] = 0;
      }
    }
    if(wFlag){
      for(int i = 0; i < w; ++i){
        matrix[i][0] = 0;
      }
    }
  }
}
