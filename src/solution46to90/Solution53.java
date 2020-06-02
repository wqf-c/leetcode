package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/3
 * Time: 0:11
 */
public class Solution53 {

  public int maxSubArray(int[] nums) {
    int[] array = new int[nums.length];
    array[0] = nums[0];
    int max = nums[0];
    for(int i = 1; i < array.length; ++i){
      if(array[i - 1] > 0) array[i] = array[i - 1] + nums[i];
      else array[i] = nums[i];
      if(array[i] > max) max = array[i];
    }
    return max;
  }
}
