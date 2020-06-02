package solution46to90;

import javafx.print.Collation;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author: wqf
 * Date: 2020/2/26
 * Time: 0:30
 */
public class Solution47 {

  public static void main(String[] args) {
    List<List<Integer>> lists = permuteUnique(new int[]{2, 2, 1, 1});
    for (List<Integer> l : lists){
      for(Integer i : l){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int len = nums.length;
    if(nums.length == 0) return result;
    ArrayList<Integer> list = new ArrayList<>();
    for(int i : nums){
      list.add(i);
    }
    HashSet<Integer> save = new HashSet<>();
    dfs(result, 0, list, len, save);
    return result;
  }

  public static void dfs(List<List<Integer>> result, int index, ArrayList<Integer> nums, int len, HashSet<Integer> save){
    if(index == len){
      int number = 0;
      for(int i = 0; i < nums.size(); ++i){
        number = number * 10 + nums.get(i);
      }
      if(!save.contains(number)){
        result.add(new ArrayList<>(nums));
        save.add(number);
      }

    }else{
      dfs(result, index + 1, nums, len, save);
      for(int i = index + 1; i < len; ++i){
        if(!(nums.get(i).equals(nums.get(index)))){
          Collections.swap(nums, index, i);
          dfs(result, index + 1, nums, len, save);
          Collections.swap(nums, index, i);
        }
      }
    }
  }


//  作者：liweiwei1419
//  链接：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  public List<List<Integer>> permuteUnique1(int[] nums) {
    int len = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    if (len == 0) {
      return res;
    }

    // 修改 1：排序（这里用升序），为了剪枝方便
    Arrays.sort(nums);

    boolean[] used = new boolean[len];
    // 使用 Deque 是 Java 官方 Stack 类的建议
    Deque<Integer> path = new ArrayDeque<>(len);
    dfs(nums, len, 0, used, path, res);
    return res;
  }

  private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> stack, List<List<Integer>> res) {
    if (depth == len) {
      res.add(new ArrayList<>(stack));
      return;
    }
    for (int i = 0; i < len; i++) {
      if (!used[i]) {

        // 修改 2：在 used[i - 1] 刚刚被撤销的时候剪枝，说明接下来会被选择，搜索一定会重复，故"剪枝"
        if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
          continue;
        }

        used[i] = true;
        stack.addLast(nums[i]);
        dfs(nums, len, depth + 1, used, stack, res);

        // 回溯，撤销选择
        stack.removeLast();
        used[i] = false;
      }
    }
  }



}
