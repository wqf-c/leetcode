package solution1to45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/14
 * Time: 15:45
 */
public class Solution18 {

  public static void main(String[] args) {
    List<List<Integer>> res = fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
    for(List<Integer> l : res){
      System.out.println(l);
    }
  }
  public static List<List<Integer>> fourSum(int[] nums, int target) {

    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length < 4){
      return result;
    }
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    if(nums[0] + nums[1] + nums[2] + nums[3] > target) return result;
    for(int i = 0; i < nums.length - 3;){
      int target1 = target - nums[i];

      for(int j = i + 1; j < nums.length - 2;){
        int target2 = target1 - nums[j];
        int k = j + 1;
        int l = nums.length - 1;
        while (k < l){

          if(target2 > nums[k] + nums[l]) k ++;
          else if(target2 < nums[k] + nums[l]) l --;
          else{
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[k]);
            list.add(nums[l]);
            result.add(list);
            int t1 = nums[k];
            int t2 = nums[l];
            while (k < nums.length && nums[k] == t1) k ++;
            while (l > 0 && nums[l] == t2) l --;
          }
        }
        int t = nums[j];
        while (j < nums.length - 2 && nums[j] == t){
          j ++;
        }
      }
      int t = nums[i];
      while (i < nums.length - 3 && nums[i] == t){
        i ++;
      }
    }
    return result;
  }
}
