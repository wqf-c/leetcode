package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/12
 * Time: 21:05
 */
public class Solution70 {

  public int climbStairs(int n) {
    int[] result = new int[n];
    if(n == 1) return 1;
    if(n == 2) return 2;
    result[0] = 1;
    result[1] = 2;
    for(int i = 2; i < n; ++i){
      result[i] = result[i - 1] + result[i - 2];
    }
    return result[n - 1];
  }
}
