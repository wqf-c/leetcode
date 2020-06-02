package solution1to45;

import java.util.Arrays;

/**
 * Author: wqf
 * Date: 2020/2/19
 * Time: 19:45
 */
public class Solution35 {

  public static void main(String[] args) {
    System.out.println(searchInsert(new int[]{1}, 1));
  }

  public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    if(nums[0] > target) return 0;
    if (nums[nums.length - 1] < target) return nums.length;
    int mid = 0;
    //System.out.println(Arrays.toString(nums));
    while (left <= right){
      mid = (left + right) / 2;
      if(nums[mid] == target) return mid;
      else if(nums[mid] < target) left = mid + 1;
      else right = mid - 1;
    }
    return left;
  }
}
