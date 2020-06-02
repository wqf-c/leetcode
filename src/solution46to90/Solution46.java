package solution46to90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/25
 * Time: 0:40
 */
public class Solution46 {

  public static void main(String[] args) {

  }

  //3 ms
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    if(nums.length == 0) return list;
    List<Integer> rest = new ArrayList<>();
    for(int i = 0; i < nums.length; ++i){
      rest.add(nums[i]);
    }

    per(rest, new ArrayList<>(), list);
    return list;
  }

  public static void per(List<Integer> rest, List<Integer> contain, List<List<Integer>> lists){
    if(rest.isEmpty()) {
      lists.add(new ArrayList<>(contain));
      return;
    }
    for(int i = rest.size() - 1; i >= 0; --i){
      int temp = rest.get(i);
      contain.add(temp);
      rest.remove(i);
      per(rest, contain, lists);
      rest.add(i, temp);
      contain.remove(contain.size() - 1);
    }
  }

//  作者：LeetCode
//  链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  //1 ms
  public void backtrack(int n,
                        ArrayList<Integer> nums,
                        List<List<Integer>> output,
                        int first) {
    // if all integers are used up
    if (first == n)
      output.add(new ArrayList<Integer>(nums));
    for (int i = first; i < n; i++) {
      // place i-th integer first
      // in the current permutation
      Collections.swap(nums, first, i);
      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1);
      // backtrack
      Collections.swap(nums, first, i);
    }
  }

  public List<List<Integer>> permute1(int[] nums) {
    // init output list
    List<List<Integer>> output = new LinkedList();

    // convert nums into list since the output is a list of lists
    ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    for (int num : nums)
      nums_lst.add(num);

    int n = nums.length;
    backtrack(n, nums_lst, output, 0);
    return output;
  }


}
