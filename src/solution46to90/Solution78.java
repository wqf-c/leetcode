package solution46to90;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/4/14
 * Time: 22:21
 */
public class Solution78 {

  List<List<Integer>> result = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();
  public List<List<Integer>> subsets(int[] nums) {
    function(nums, 0);
    return result;
  }

  void function(int[] nums, int index){
    if(index == nums.length){
      List<Integer> add = new ArrayList<>(temp);
      result.add(add);
      return;
    }
    temp.add(nums[index]);
    function(nums, index + 1);
    temp.remove(temp.size() - 1);
    function(nums, index + 1);
  }
}
