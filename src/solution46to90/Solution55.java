package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/4
 * Time: 1:27
 */
public class Solution55 {

  public boolean canJump(int[] nums) {
    int len = nums.length;
    if(len == 0) return true;
    if(nums[0] == 0 && nums.length != 1) return false;
    int boundary = nums[0];
    int start = 1;
    while (true){
      if(boundary >= len - 1) return true;
      int max = start + nums[start];
      for(int i = start; i <= boundary; ++i){
        if(i + nums[i] > max) max = i + nums[i];
      }
      start = boundary + 1;
      if(max <= boundary) return false;
      else boundary = max;
    }

  }
}
