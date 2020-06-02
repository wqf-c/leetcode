package solution1to45;

import java.util.Arrays;

/**
 * Author: wqf
 * Date: 2020/2/19
 * Time: 17:32
 */
public class Solution34 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
  }
//[5,7,7,8,8,10]
//  8
  public static int[] searchRange(int[] nums, int target) {
    int[] result = new int[]{-1, -1};
    if(nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target){
      return result;
    }
    search(nums, 0, nums.length - 1, target, result);
    return result;
  }

  public static void search(int[] nums, int left, int right, int target, int[] result){
    System.out.println("left:" + left + " right:" + right);
    if(left > right) {
      return;
    }
    int mid = (left + right) / 2;
    if(nums[mid] == target){
      if(result[0] == -1 && result[1] == -1) {
        result[0] = mid;
        result[1] = mid;
      }
      if(mid < result[0]) result[0] = mid;
      if(mid > result[1]) result[1] = mid;
      if(mid > 0 && nums[mid - 1] == target) search(nums, left, mid - 1,target, result);
      if(mid < nums.length - 1 && nums[mid + 1] == target) search(nums, mid + 1, right, target, result);
    }else if(nums[mid] > target){
      search(nums, left, mid - 1, target, result);
    }else{
      search(nums, mid + 1, right, target, result);
    }

  }
}
