package solution46to90;

/**
 * Author: wqf
 * Date: 2020/4/19
 * Time: 0:57
 */
public class Solution81 {

  public static boolean search(int[] nums, int target) {
    if(nums == null || nums.length == 0) return false;
    if(nums.length == 1){
      if(nums[0] == target) return true;
      else return false;
    }
    int start = 0;
    int step = 1;
    int end = nums.length - 1;
    int startValue = nums[0];
    if(target <= nums[nums.length - 1]){
      start = nums.length - 1;
      end = 0;
      step = -1;
      startValue = nums[nums.length - 1];
    }
    if(nums[start] == target) return true;
    while (true){
      if(start < 0 || start >= nums.length) break;
      if(nums[start] == target) return true;
      if(step > 0 && nums[start] > target) break;
      if(step < 0 && nums[start] < target) break;
      if(((step > 0 && start + step < nums.length && nums[start + step] < target && nums[start + step] > startValue)) ||
        (step < 0 && start + step >= 0 && nums[start + step] > target && nums[start + step] < startValue )) {
        start = start + step;
        step *= 2;
      }
      else{
        if(step < 0) step = -1;
        else step = 1;
        start += step;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(search(new int[]{1, 1, 3, 1, 1}, 3));
  }
}
