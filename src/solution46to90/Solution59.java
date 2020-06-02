package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/6
 * Time: 1:07
 */
public class Solution59 {

  public static void main(String[] args) {
    generateMatrix(3);
  }

  public static int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int current = 1;
    int height = n - 1;
    int width = n - 1;
    n = 0;
    while (true){
      if(current == (width+1) * (height+1) + 1) break;
      for(int i = n; i < width - n; ++i){
        result[n][i] = current ++;
      }
      for(int i = n; i < height - n; ++i){
        result[i][width - n] = current ++;
      }
      for(int i = width - n; i > n; i--){
        result[height - n][i] = current ++;
      }
      for(int i = height - n; i > n; i--){
        result[i][n] = current ++;
      }
      if(current == (width + 1)*(height + 1)){
        result[width/2][height/2] = current;
        break;
      }
      n++;
    }
    return result;
  }
}
