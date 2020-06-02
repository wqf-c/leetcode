package solution1to45;

import java.util.Arrays;

/**
 * Author: wqf
 * Date: 2020/2/23
 * Time: 0:25
 */
public class Solution45 {

  public static void main(String[] args) {
    jump(new int[]{2, 3, 1, 1, 4});
  }
  //动态规划  效率太低
  public static int jump(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    dp[0] = 0;
    for(int i = 0; i < len - 1; ++i){
      int nowStep = dp[i];
      for(int j = 1; j <= nums[i] && i + j < len; ++j){
        if(dp[i + j] == 0 || nowStep + 1 < dp[i + j]) dp[i + j] = nowStep + 1;
      }
    }
    return dp[len - 1];
  }

  //贪心算法
  public static int jump1(int[] nums){
    int end = 0;
    int maxPosition = 0;
    int step = 0;
    for(int i = 0; i < nums.length; ++i){
      maxPosition = Math.max(maxPosition, nums[i] + i);
      if(maxPosition > nums.length) return step++;
      if(i == end){
        step ++;
        end = maxPosition;
      }
    }
    return step;
  }
}
