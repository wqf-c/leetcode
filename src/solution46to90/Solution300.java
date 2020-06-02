package solution46to90;

/**
 * Author: wqf
 * Date: 2020/4/16
 * Time: 23:29
 */
public class Solution300 {

  public int lengthOfLIS(int[] nums) {
    int []dp = new int[nums.length];
    dp[0] = 1;
    for(int i = 1; i < dp.length; ++i){
      int max = 0;
      for(int j = 0; j < i; ++j){
        if(nums[i] > nums[j] && dp[j] + 1 > max){
          max = dp[j] + 1;
        }
      }
      dp[i] = max;
    }
    int max = 0;
    for(int i = 0; i < dp.length; ++i){
      if(dp[i] > max){
        max = dp[i];
      }
    }
    return max;
  }
}
