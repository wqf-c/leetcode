package solution1to45;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: wqf
 * Date: 2020/1/29
 * Time: 22:34
 */
public class Solution1 {
  //暴力解法
//  public int[] twoSum(int[] nums, int target) {
//    for(int i = 0; i < nums.length; ++i){
//      for(int j = i + 1; j < nums.length; ++j){
//        if(nums[i] + nums[j] == target){
//          return new int[]{i, j};
//        }
//      }
//    }
//    return new int[]{0, 0};
//  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0;  i < nums.length; ++i){
      int dif = target - nums[i];
      if(map.get(dif) != null){
        return new int[]{i, map.get(dif)};
      }
      map.put(nums[i], i);
    }
    return new int[]{0, 0};
  }

  public static void main(String[] args) {

  }

}
