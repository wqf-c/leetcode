package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/21
 * Time: 19:26
 */
public class Solution41 {

  //遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
  // 然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，
  // 否则遍历完都没出现那么答案就是数组长度加1。
  public int firstMissingPositive(int[] nums) {
    int len = nums.length;
    for(int i = 0; i < len; ++i){
      while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]){
        int temp = nums[i];
        nums[i] = nums[nums[i] - 1];
        nums[temp - 1] = temp;
      }
    }
    for(int i = 0; i < len; ++i){
      if(nums[i] != i + 1){
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  public void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
