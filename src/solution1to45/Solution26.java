package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/17
 * Time: 0:57
 */
public class Solution26 {

  public int removeDuplicates(int[] nums) {
    if(nums.length == 0) return 0;
    int sum = 0;
    for(int i = 0; i < nums.length; ++i){
      if(i == 0 || nums[i] != nums[i - 1]){
        nums[sum] = nums[i];
        sum += 1;
      }
    }
    return sum;
  }

}
