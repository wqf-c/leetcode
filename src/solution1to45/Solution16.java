package solution1to45;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author: wqf
 * Date: 2020/2/12
 * Time: 23:13
 */
public class Solution16 {

  public static void main(String[] args) {
    System.out.println(threeSumClosest(new int[]{-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33}, 0));
  }

  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    int delta = Integer.MAX_VALUE;
    for(int i = 0; i < nums.length - 2; ++i){
      int j = i + 1;
      int k = nums.length - 1;
      int last_delta = Integer.MAX_VALUE;
      while (k > j){
        int d = nums[i] + nums[j] + nums[k] - target;
        if(Math.abs(d) <= Math.abs(last_delta) ){
          last_delta = d;
        }
        if(d == 0) return target;
        if(d < 0) j ++;
        else k --;
      }
      if(Math.abs(delta) > Math.abs(last_delta)){
        delta = last_delta;
      }
    }
    return target + delta;
  }
}
