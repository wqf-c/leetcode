package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/17
 * Time: 17:20
 */
public class Solution27 {

  public int removeElement(int[] nums, int val) {
    int index = -1;
    for(int i = 0; i < nums.length; ++i){
      if(nums[i] != val){
        index ++;
        nums[index] = nums[i];
      }
    }
    return index + 1;
  }
}
